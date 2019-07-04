package pl.erizo.jcstress.playground.jvm.startstop;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.L_Result;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class StartStopTest {

    @State
    public static class S {
        public final String id = UUID.randomUUID().toString();
        private final Logger logger = new Logger(id);

        public S() {
            logger.log("<init> S() start");

            // do setup...

            logger.log("<init> S() end");
        }
    }

    @JCStressTest
    @Outcome(id = "false", expect = Expect.ACCEPTABLE, desc =
            "something that won't happen")
    public static class startupShutdown {

        @Actor
        public void actor1(final S s) {
            s.logger.log("actor1() start");

            // do something

            s.logger.log("actor1() end");
        }

        @Actor
        public void actor2(final S s) {
            s.logger.log("actor2() start");

            // do something

            s.logger.log("actor2() end");
        }

        @Arbiter
        public void arbiter(final S s, final L_Result r) {
            s.logger.log("arbiter() start");

            // do something...
            // do s.teardown...

            r.r1 = true;

            s.logger.log("arbiter() end");
        }
    }

    public static class Logger {
        private final String id;
        private final Path logFile;

        public Logger(final String id) {
            this.id = id;
            this.logFile = Paths.get("c:/temp/jcstress/StartStopTest-" + id + ".log");
            try {
                Files.write(logFile,
                        Arrays.asList(logTime(System.currentTimeMillis()) + " [" + id + " @ "
                                + getPid() + " / " + Thread.currentThread().getName() + "]: <init> Logger"), StandardOpenOption.CREATE_NEW);
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static String logTime(final long ms) {
            final SimpleDateFormat sdfDate = new
                    SimpleDateFormat("HH:mm:ss.SSS");
            return sdfDate.format(new Date(ms));
        }

        private String getPid() {
            return ManagementFactory.getRuntimeMXBean().getName();
        }

        public void log(final String msg) {
            try {
                synchronized (logFile) {
                    Files.write(logFile,
                            Arrays.asList(logTime(System.currentTimeMillis()) + " [" + id + " @ "
                                    + getPid() + " / " + Thread.currentThread().getName() + "]: " + msg),
                            StandardOpenOption.APPEND);
                }
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
