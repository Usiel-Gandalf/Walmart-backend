package com.walmart.exam.auth.service;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.walmart.exam.auth.jwt.JwtService;
import com.walmart.exam.auth.models.Role;
import com.walmart.exam.auth.models.User;
import com.walmart.exam.auth.repository.UserRepository;
import com.walmart.exam.auth.request.LoginRequest;
import com.walmart.exam.auth.request.RegisterRequest;
import com.walmart.exam.utils.AuthResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        Optional<User> user = userRepository.findByUsername(request.getUsername());
        
        String token= "";
        
        if(user == null) {
        	System.out.println("No existe el usuario mi rey");
            return AuthResponse.builder()
                    .estatus(false)
                    .message("Algo salio mal con el inicio de sesion ")
                    .build();
        	
        }else {
        	System.out.println("Si existe el usuario mi rey");
        	token=jwtService.getToken(user.get());
            return AuthResponse.builder()
            		.estatus(true)
                    .token(token)
                    .build();
        }
        
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .country(request.getCountry())
            .role(Role.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
        	.estatus(true)	
            .token(jwtService.getToken(user))
            .build();
        
    }
}
