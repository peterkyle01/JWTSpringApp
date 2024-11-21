package com.peterkyle01.user.service;

import com.peterkyle01.user.User;
import com.peterkyle01.user.dto.UserRequest;
import com.peterkyle01.user.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapperService {
    public User userRequestToUser(UserRequest userRequest) {
        return User.builder().firstName(userRequest.firstName()).lastName(userRequest.lastName()).email(userRequest.email()).password(userRequest.password()).role(userRequest.role()).build();
    }

    public UserResponse userToUserResponse(User user) {
        return new UserResponse(user.getFirstName(), user.getLastName(), user.getEmail());
    }

    public List<UserResponse> usersToUserResponse(List<User> users) {
        return users.stream().map(this::userToUserResponse).toList();
    }
}
