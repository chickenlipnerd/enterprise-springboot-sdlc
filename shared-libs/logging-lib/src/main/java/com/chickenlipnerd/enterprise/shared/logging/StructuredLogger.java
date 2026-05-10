package com.chickenlipnerd.enterprise.shared.logging;

import java.util.Map;
import java.util.StringJoiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class StructuredLogger {

    private final Logger logger;

    private StructuredLogger(Class<?> source) {
        this.logger = LoggerFactory.getLogger(source);
    }

    public static StructuredLogger forClass(Class<?> source) {
        return new StructuredLogger(source);
    }

    public void info(String message, Map<String, ?> context) {
        logger.info("{} {}", message, formatContext(context));
    }

    public void warn(String message, Map<String, ?> context, Throwable throwable) {
        logger.warn("{} {}", message, formatContext(context), throwable);
    }

    public static String formatContext(Map<String, ?> context) {
        if (context == null || context.isEmpty()) {
            return "";
        }

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        context.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> joiner.add(entry.getKey() + '=' + entry.getValue()));
        return joiner.toString();
    }
}
