package com.slinger.greenfieldworld.model.common;

public final class MessageUtil {

    public static String format(String message, Object... args) {

        String output = message;

        for (int i = 0; i < args.length; i++) {

            Object object = args[i];

            output = output.replaceFirst("\\{" + i + "\\}", object.toString());
        }

        return output;
    }
}