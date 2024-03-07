package com.example.smallsquareservice.infrastructure.client;


import com.example.smallsquareservice.infrastructure.configuration.ClientConfiguration;
import com.example.smallsquareservice.infrastructure.ouput.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "users-service",url = "http://localhost:8080/user/", configuration = ClientConfiguration.class)
public interface UserClient {
    @GetMapping(value = "{userId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    Optional<UserEntity> getUserById(@PathVariable(name = "userId") Long userId);

    @GetMapping(value = "email/{email}",consumes = MediaType.APPLICATION_JSON_VALUE)
    Optional<UserEntity> getUserByEmail(@PathVariable String email);
}
