package com.rosyidgrobogan.belajarspringapi.models.repositories;

import com.rosyidgrobogan.belajarspringapi.models.enities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends PagingAndSortingRepository<User, Long> {

    // ex. derived name query
    Optional<User> findByEmail(String email);
}
