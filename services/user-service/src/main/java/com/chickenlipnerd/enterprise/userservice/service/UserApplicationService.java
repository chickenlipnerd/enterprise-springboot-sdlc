package com.chickenlipnerd.enterprise.userservice.service;

import com.chickenlipnerd.enterprise.shared.logging.StructuredLogger;
import com.chickenlipnerd.enterprise.shared.validation.ValidationSupport;
import com.chickenlipnerd.enterprise.userservice.model.User;
import com.chickenlipnerd.enterprise.userservice.model.UserSummary;
import com.chickenlipnerd.enterprise.userservice.repository.UserRepository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

    private static final List<UserSummary> FALLBACK_USERS = List.of(
        new UserSummary("ada", "ada@example.com", "ACTIVE"),
        new UserSummary("grace", "grace@example.com", "PENDING")
    );

    private static final StructuredLogger LOGGER = StructuredLogger.forClass(UserApplicationService.class);

    private final UserRepository userRepository;

    public UserApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserSummary> listUsers() {
        try {
            List<UserSummary> users = userRepository.findTop10ByOrderByUsernameAsc().stream()
                .map(this::toSummary)
                .toList();
            return users.isEmpty() ? FALLBACK_USERS : users;
        } catch (RuntimeException exception) {
            LOGGER.warn("Falling back to sample users", Map.of("service", "user-service"), exception);
            return FALLBACK_USERS;
        }
    }

    public UserSummary getUser(String username) {
        String validatedUsername = ValidationSupport.requireNotBlank(username, "username");
        return listUsers().stream()
            .filter(user -> user.username().equalsIgnoreCase(validatedUsername))
            .findFirst()
            .orElse(new UserSummary(validatedUsername, validatedUsername + "@example.com", "NOT_FOUND"));
    }

    private UserSummary toSummary(User user) {
        return new UserSummary(user.getUsername(), user.getEmailAddress(), user.getStatus());
    }
}
