package org.usfirst.frc.team2175.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;

public class LoggingConfigTest extends TestBase {
    /**
     * Verifies can find and read the logging config properties file and
     * displays example logging output.
     */
    @Test
    public void testConfigAndDisplay() {
        BaseConfig.setPropertyFileDir(PROPERTY_FILE_DIR_SRC_COMPETITION);
        new LoggingConfig();

        final Logger log = Logger.getLogger(getClass().getName());

        // disable these for runs during build to not show the stacktrace
        // as it looks like a problem during the build
        // final Exception e = new IllegalArgumentException("exception msg");
        // log.log(Level.SEVERE, "Exception msg", e);

        log.info("log an info msg");
        log.config("log a config msg");
        log.fine("log a fine msg");
        log.finer("log a finer msg");
        log.finest("log a finest msg");

        final Level level = log.getLevel();
        // FIXME
        // assertThat("Log level is null.", level, notNullValue());
    }
}
