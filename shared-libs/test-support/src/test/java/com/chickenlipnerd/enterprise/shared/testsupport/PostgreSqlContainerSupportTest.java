package com.chickenlipnerd.enterprise.shared.testsupport;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PostgreSqlContainerSupportTest {

    @Test
    void createsAConfiguredPostgresContainer() {
        var container = PostgreSqlContainerSupport.createContainer("user_service_test");

        assertThat(container.getDockerImageName()).isEqualTo("postgres:17-alpine");
        assertThat(container.getDatabaseName()).isEqualTo("user_service_test");
        assertThat(container.getUsername()).isEqualTo("postgres");
    }
}
