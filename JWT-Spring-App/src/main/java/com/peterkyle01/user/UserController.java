package com.peterkyle01.user;

import com.peterkyle01.user.dto.UserRequest;
import com.peterkyle01.user.dto.UserResponse;
import com.peterkyle01.user.service.UserMapperService;
import com.peterkyle01.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapperService userMapperService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        User user = userMapperService.userRequestToUser(request);
        User userResponse = userService.createUser(user);
        return ResponseEntity.ok(userMapperService.userToUserResponse(userResponse));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(userMapperService.usersToUserResponse(users));
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getOneUserByEmail(@RequestParam("email") String email) {
        User user = userService.getOneUserByEmail(email);
        return ResponseEntity.ok(userMapperService.userToUserResponse(user));
    }
}

