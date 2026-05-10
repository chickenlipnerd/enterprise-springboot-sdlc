package com.chickenlipnerd.enterprise.shared.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseEntityTest {

    @Test
    void entityIsNewUntilIdIsAssigned() {
        SampleEntity entity = new SampleEntity();

        assertThat(entity.isNew()).isTrue();

        entity.setId(java.util.UUID.randomUUID());

        assertThat(entity.isNew()).isFalse();
    }

    private static final class SampleEntity extends BaseEntity {
    }
}
