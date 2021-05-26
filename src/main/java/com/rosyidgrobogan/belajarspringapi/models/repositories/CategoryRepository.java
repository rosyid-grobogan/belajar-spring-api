package com.rosyidgrobogan.belajarspringapi.models.repositories;

import com.rosyidgrobogan.belajarspringapi.models.enities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
