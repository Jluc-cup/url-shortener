package com.urlshortener.util;

import java.util.UUID;

public class StringUtil {

    public static String uuidGenerate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
