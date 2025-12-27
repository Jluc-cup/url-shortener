package com.urlshortener.util;

import java.time.Instant;

public class DateTimeUtil {

    private static Instant CURRENT_TIME = Instant.MIN;

    public static Instant getCurrent() {
        if (CURRENT_TIME == Instant.MIN) {
            return Instant.now();
        }
        return CURRENT_TIME;
    }

}
