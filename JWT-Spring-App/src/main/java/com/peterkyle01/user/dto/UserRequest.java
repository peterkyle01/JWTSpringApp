package com.peterkyle01.user.dto;

import com.peterkyle01.user.Role;

public record UserRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        Role role
) {
}
