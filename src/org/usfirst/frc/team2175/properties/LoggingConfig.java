package org.usfirst.frc.team2175.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SocketHandler;
import java.util.logging.XMLFormatter;

public class LoggingConfig extends BaseProperties {
    /** Set to root package, and must match one set in logging.properties. */
    public static final String ROOT_LOGGER_NAME = "org.usfirst.frc.team2175";

    private static final String PROPERTY_FILE_NAME = "logging.properties";

    @Override
    protected String getPropertyFileName() {
        return PROPERTY_FILE_NAME;
    }

    @Override
    protected void populate() {
        final String propertyFile = getFullyQualifiedPropertyFileName();
        System.out.println("Using logging property file=" + propertyFile);

        initializeFileLog(propertyFile);
        initializeSocketLog();
    }

    protected void initializeFileLog(final String propertyFile) {
        System.out.println("Initializing file logging");

        final LogManager logManager = LogManager.getLogManager();

        // regretfully the icky java.util.logging won't allow adding an existing
        // property file to it so we have to reload the properties file again
        try (final InputStream in = new FileInputStream(propertyFile)) {
            logManager.readConfiguration(in);
        } catch (final FileNotFoundException e) {
            throw new IllegalStateException(
                    "Did not find logging properties file=" + propertyFile
                            + ", msg=" + e.getMessage(), e);
        } catch (SecurityException | IOException e) {
            throw new IllegalStateException("Unable to read logging properties",
                    e);
        }

        final String levelProperty =
                logManager.getProperty("java.util.logging.FileHandler.level");

        final Logger log = Logger.getLogger(getClass().getName());
        final Level level = log.getLevel();
        log.info("File logging initialized, actual logging level=" + level
                + ", configured level=" + levelProperty);
    }

    protected void initializeSocketLog() {
        System.out.println("Initializing socket logging");

        final Handler handler = makeSocketHandler();

        if (handler != null) {
            configureSocketHandler(handler);
        }
    }

    protected Handler makeSocketHandler() {
        final Logger log = Logger.getLogger(getClass().getName());

        final String socketHandlerHostname =
                getStringPropertyValue("socket.handler.hostname");
        final int socketHandlerPort = getIntPropertyValue("socket.handler.port");

        log.config("host=" + socketHandlerHostname + ", port="
                + socketHandlerPort);

        Handler handler = null;
        try {
            handler =
                    new SocketHandler(socketHandlerHostname, socketHandlerPort);
        } catch (final IOException e) {
            final String msg =
                    "Lilith log viewer not running?"
                            + " Error instantiating SocketHandler with host="
                            + socketHandlerHostname + ", port="
                            + socketHandlerPort + ", msg="
                            + e.getClass().getName() + ": " + e.getMessage();
            log.info(msg);
        }
        return handler;
    }

    protected void configureSocketHandler(final Handler handler) {
        final String handlerEncoding = "UTF-8";
        try {
            handler.setEncoding(handlerEncoding);
        } catch (SecurityException | UnsupportedEncodingException e) {
            throw new IllegalStateException("Error setting handler encoding="
                    + handlerEncoding, e);
        }

        final Formatter socketHandlerFormatter = new XMLFormatter();
        handler.setFormatter(socketHandlerFormatter);

        final Logger rootLogger = Logger.getLogger("");
        rootLogger.addHandler(handler);
    }
}
