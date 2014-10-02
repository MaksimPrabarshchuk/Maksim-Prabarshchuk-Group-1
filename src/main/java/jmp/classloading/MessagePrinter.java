package jmp.classloading;

import org.apache.log4j.Logger;

/**
 * Simple class which prints current time in milliseconds.
 *
 * @author Mikalai_Lohach
 *
 */
public class MessagePrinter {

    private static final Logger LOG = Logger.getLogger("MessagePrinter");

    public static void main(String[] args) {
        LOG.debug("MessagePrinter successfully loaded - " + System.currentTimeMillis());
    }
}
