package com.example.partypad.Security.auth;

import com.example.partypad.Security.config.JwtService;
import com.example.partypad.dao.UserRepository;
import com.example.partypad.entity.Authority;
import com.example.partypad.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    private SessionFactory sessionFactory;



    public AuthenticationResponse register(RegisterRequest request) {

        System.out.println("AuthenticationService register run ");

        var user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEnabled(request.getEnabled());

        System.out.println("user build");

        var authority = new Authority();
        authority.setUser(user);
        authority.setAuthority("ROLE_USER");

        System.out.println("authority build");

        user.setAuthorities(new HashSet<>(Collections.singletonList(authority)));

        System.out.println("user ready");

        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
//        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();

    }

//    private void saveUserToken(User user, String jwtToken) {
//        var token = Token.builder()
//                .user(user)
//                .token(jwtToken)
//                .tokenType(TokenType.BEARER)
//                .expired(false)
//                .revoked(false)
//                .build();
//        tokenRepository.save(token);
//    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("AuthenticationService authenticate run ");
        System.out.println("request.getUsername() :"+request.getUsername());
        System.out.println(" request.getPassword() :"+request.getPassword());



        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        System.out.println("request.getUsername() :"+request.getUsername());
        System.out.println(" request.getPassword() :"+request.getPassword());
        System.out.println("AuthenticationService authenticationManager.authenticate run ");
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        System.out.println("AuthenticationService repository.findByUsername run ");
        var jwtToken = jwtService.generateToken(user);
        System.out.println("AuthenticationService authenticate jwtToken  :"+jwtToken);

        var refreshToken = jwtService.generateRefreshToken(user);
//        revokeAllUserTokens(user);
//        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

}
