package com.chickenlipnerd.enterprise.userservice.repository;

import com.chickenlipnerd.enterprise.userservice.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findTop10ByOrderByUsernameAsc();

    Optional<User> findByUsername(String username);
}
