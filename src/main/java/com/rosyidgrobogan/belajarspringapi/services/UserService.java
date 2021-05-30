package com.rosyidgrobogan.belajarspringapi.services;

import com.rosyidgrobogan.belajarspringapi.models.enities.User;
import com.rosyidgrobogan.belajarspringapi.models.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRespository userRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRespository userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(
                                "user with email '%s' not found", email
                        )));
    }

    public User registerUser(User user) {
        boolean userExists = userRepo.findByEmail(user.getEmail()).isPresent();
        if (userExists){
            throw new RuntimeException(
                    String.format("User with email '%s' already exist", user.getEmail())
            );
        }

        // proses encode password
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepo.save(user);
    }
}
