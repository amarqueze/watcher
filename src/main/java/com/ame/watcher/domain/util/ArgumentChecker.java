package com.ame.watcher.domain.util;

import org.apache.logging.log4j.util.Strings;

public class ArgumentChecker {
    private ArgumentChecker() {}

    public static void checkIsValidString(String input, String msgIfInvalidInput) {
        if(Strings.isBlank(input))
            throw new IllegalArgumentException(msgIfInvalidInput);
    }
}
