package com.chickenlipnerd.enterprise.shared.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ValidationSupportTest {

    @Test
    void rejectsBlankValues() {
        assertThatThrownBy(() -> ValidationSupport.requireNotBlank("   ", "username"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("username must not be blank");
    }

    @Test
    void returnsValidValues() {
        assertThat(ValidationSupport.requireNotBlank("catalog", "name")).isEqualTo("catalog");
    }
}
