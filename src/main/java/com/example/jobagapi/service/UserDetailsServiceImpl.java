package com.example.jobagapi.service;

import com.example.jobagapi.domain.repository.UserRepository;
import com.example.jobagapi.domain.service.DefaultUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements DefaultUserDetailsService {
    private static final String DEFAULT_USERNAME = "john.doe@gmail.com";
    private static final List<GrantedAuthority> DEFAULT_AUTHORITIES = new ArrayList<>();
    private List<com.example.jobagapi.domain.model.User> users = new ArrayList<>();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: Implement Repository-based User Store
        users = userRepository.findAll();


        String defaultPassword = passwordEncoder.encode("password");
        if(DEFAULT_USERNAME.equals(username)) {
            return new User(DEFAULT_USERNAME, defaultPassword, DEFAULT_AUTHORITIES);
        }


        for (com.example.jobagapi.domain.model.User user : users){
            if (user.getEmail().equals(username)){
                return new User(username, passwordEncoder.encode(user.getPassword()), DEFAULT_AUTHORITIES);
            }
        }
        throw new UsernameNotFoundException("User not found with username " + username);

    }

    public Long getUserId(String username) throws UsernameNotFoundException {
        users = userRepository.findAll();
        for (com.example.jobagapi.domain.model.User user: users){
            if (user.getEmail().equals(username)){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return user.getId();
            }
        }
        throw new UsernameNotFoundException("User not found with username " + username);
    }

    /*
    public List<User> getAll() {
        return Arrays.asList(
                new User("john.doe@gmail.com",
                        passwordEncoder.encode("password"),
                        DEFAULT_AUTHORITIES),
                new User("jason.bourne@treatstone.gov",
                        passwordEncoder.encode("easy-one"),
                        DEFAULT_AUTHORITIES)
        );
    }
     */
}