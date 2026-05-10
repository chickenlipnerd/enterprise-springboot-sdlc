package com.chickenlipnerd.enterprise.userservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.chickenlipnerd.enterprise.userservice.model.User;
import com.chickenlipnerd.enterprise.userservice.repository.UserRepository;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserApplicationServiceTest {

    @Test
    void mapsRepositoryUsersWhenAvailable() {
        UserRepository repository = mock(UserRepository.class);
        when(repository.findTop10ByOrderByUsernameAsc())
            .thenReturn(List.of(new User("ada", "ada@example.com", "ACTIVE")));

        UserApplicationService service = new UserApplicationService(repository);

        assertThat(service.listUsers())
            .extracting(user -> user.username())
            .containsExactly("ada");
    }

    @Test
    void fallsBackToSampleUsersWhenRepositoryFails() {
        UserRepository repository = mock(UserRepository.class);
        when(repository.findTop10ByOrderByUsernameAsc()).thenThrow(new IllegalStateException("database unavailable"));

        UserApplicationService service = new UserApplicationService(repository);

        assertThat(service.listUsers()).hasSize(2);
    }
}
