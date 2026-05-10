package com.chickenlipnerd.enterprise.shared.testsupport;

import org.testcontainers.containers.PostgreSQLContainer;

public final class PostgreSqlContainerSupport {

    private static final String IMAGE_NAME = "postgres:17-alpine";

    private PostgreSqlContainerSupport() {
    }

    public static PostgreSQLContainer<?> createContainer(String databaseName) {
        return new PostgreSQLContainer<>(IMAGE_NAME)
            .withDatabaseName(databaseName)
            .withUsername("postgres")
            .withPassword("postgres");
    }
}
