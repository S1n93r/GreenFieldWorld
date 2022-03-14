package com.slinger.greenfieldworld.model.common;

public final class MessageUtil {

    private MessageUtil() {
        /* Util */
    }

    public static String format(String message, Object... args) {

        String output = message;

        for (int i = 0; i < args.length; i++) {

            Object object = args[i];

            /* TODO: Could be replaceAll() for being able to push multiple call outs for same name. */
            output = output.replaceFirst("\\{" + i + "\\}", object.toString());
        }

        return output;
    }
}