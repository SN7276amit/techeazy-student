package com.techeazy.StudentTecheazyAssignment.service;

import com.techeazy.StudentTecheazyAssignment.dto.User;
import com.techeazy.StudentTecheazyAssignment.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JwtUserDetailsServiceTest {

	@InjectMocks
	private JwtUserDetailsService jwtUserDetailsService;

	@Mock
	private UserRepository userRepository;

	private User user;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		user = new User();
		user.setUsername("testuser");
		user.setPassword("testpassword");
	}

	@Test
    void loadUserByUsername_UserFound() {
        when(userRepository.findByUsername("testuser")).thenReturn(user);

        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername("testuser");

        assertNotNull(userDetails);
        assertEquals("testuser", userDetails.getUsername());
        assertEquals("testpassword", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().isEmpty());
    }

	@Test
    void loadUserByUsername_UserNotFound() {
        when(userRepository.findByUsername("nonexistentuser")).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            jwtUserDetailsService.loadUserByUsername("nonexistentuser");
        });
    }
}
