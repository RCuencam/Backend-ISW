package com.example.jobagapi.controller;

import com.example.jobagapi.domain.service.DefaultUserDetailsService;
import com.example.jobagapi.service.communication.AuthenticationRequest;
import com.example.jobagapi.service.communication.AuthenticationResponse;
import com.example.jobagapi.util.JwtCenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtCenter tokenCenter;
    @Autowired
    private DefaultUserDetailsService userDetailsService;

    @Operation(summary = "Authorize user", description = "Authorize user", tags = {"authentication"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Credit Cards returned", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/sign-in")
    public ResponseEntity<?> generateAuthenticationToken(
            @RequestBody AuthenticationRequest request)
            throws Exception {
        authenticate(request.getUsername(), request.getPassword());
        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.getUsername());
        Long userId = userDetailsService.getUserId(userDetails.getUsername());
        System.out.println("Password: " + request.getPassword());
        String token = tokenCenter.generateToken(userDetails);
        return ResponseEntity.ok(new
                AuthenticationResponse(userId, userDetails.getUsername(), token));
    }

    private void authenticate(String username, String password)
            throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}