package com.chickenlipnerd.enterprise.shared.validation;

import java.util.Objects;

public final class ValidationSupport {

    private ValidationSupport() {
    }

    public static String requireNotBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
        return value;
    }

    public static <T> T requireNonNull(T value, String fieldName) {
        return Objects.requireNonNull(value, fieldName + " must not be null");
    }
}
