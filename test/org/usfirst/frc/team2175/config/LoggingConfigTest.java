package org.usfirst.frc.team2175.config;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.usfirst.frc.team2175.TestBase;
import org.usfirst.frc.team2175.properties.BaseProperties;
import org.usfirst.frc.team2175.properties.LoggingConfig;

public class LoggingConfigTest extends TestBase {
    /**
     * Verifies can find and read the logging config properties file and
     * displays example logging output.
     */
    @Test
    public void testConfigAndDisplay() {
        BaseProperties.setPropertyFileDir(PROPERTY_FILE_DIR_SRC_COMPETITION);
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

        final Logger rootLog = Logger.getLogger(LoggingConfig.ROOT_LOGGER_NAME);

        final Level level = rootLog.getLevel();
        assertThat("Root log level is incorrect.", level, equalTo(Level.ALL));
    }
}
