package com.peterkyle01.auth;

import com.peterkyle01.auth.dto.AuthenticationRequest;
import com.peterkyle01.auth.dto.AuthenticationResponse;
import com.peterkyle01.auth.dto.RegisterRequest;
import com.peterkyle01.config.JWTService;
import com.peterkyle01.user.Role;
import com.peterkyle01.user.User;
import com.peterkyle01.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder().firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getEmail()))
                .role(Role.USER).build();
        userRepository.save(user);
        var token = jwtService.generateToken(new HashMap<>(), user);
        return AuthenticationResponse.builder().token(token).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
        var token = jwtService.generateToken(new HashMap<>(), user);
        return AuthenticationResponse.builder().token(token).build();
    }
}
