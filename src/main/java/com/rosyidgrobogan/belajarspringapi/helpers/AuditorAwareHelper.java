package com.rosyidgrobogan.belajarspringapi.helpers;

import com.rosyidgrobogan.belajarspringapi.models.enities.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public class AuditorAwareHelper implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // get Current User
        User currentUser = (User) SecurityContextHolder
                                            .getContext()
                                            .getAuthentication()
                                            .getPrincipal();

        return Optional.of(currentUser.getEmail());
    }
}
