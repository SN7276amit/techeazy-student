package com.techeazy.StudentTecheazyAssignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techeazy.StudentTecheazyAssignment.dto.JwtRequest;
import com.techeazy.StudentTecheazyAssignment.dto.JwtResponse;
import com.techeazy.StudentTecheazyAssignment.dto.User;
import com.techeazy.StudentTecheazyAssignment.dto.UserDTO;
import com.techeazy.StudentTecheazyAssignment.repo.UserRepository;
import com.techeazy.StudentTecheazyAssignment.security.JwtTokenUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthenticationController.class)
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private JwtRequest jwtRequest;
    private UserDTO userDTO;
    private User user;
    private UserDetails userDetails;
    private JwtResponse jwtResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        jwtRequest = new JwtRequest();
        jwtRequest.setUsername("testuser");
        jwtRequest.setPassword("password");

        userDTO = new UserDTO();
        userDTO.setUsername("testuser");
        userDTO.setPassword("password");
        userDTO.setRole("ROLE_USER");

        user = new User();
        user.setUsername("testuser");
        user.setPassword("encodedpassword");
        user.setRole("ROLE_USER");

        userDetails = org.springframework.security.core.userdetails.User
                .withUsername("testuser")
                .password("encodedpassword")
                .roles("USER")
                .build();

        jwtResponse = new JwtResponse("jwt_token");
    }

    @Test
    void createAuthenticationToken() throws Exception {
        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(userDetailsService.loadUserByUsername("testuser")).thenReturn(userDetails);
        when(jwtTokenUtil.generateToken(userDetails)).thenReturn("jwt_token");

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(jwtRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("jwt_token"));
    }

    @Test
    void saveUser() throws Exception {
        when(passwordEncoder.encode("password")).thenReturn("encodedpassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"));
    }
}
