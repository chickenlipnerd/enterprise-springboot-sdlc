package com.chickenlipnerd.enterprise.shared.logging;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class StructuredLoggerTest {

    @Test
    void formatsContextInStableOrder() {
        assertThat(StructuredLogger.formatContext(Map.of("service", "user-service", "profile", "local")))
            .isEqualTo("[profile=local, service=user-service]");
    }
}
