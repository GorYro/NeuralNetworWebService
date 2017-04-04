package com.neural.network.dao;

import com.neural.network.entity.Breeds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BreedsRepository extends JpaRepository<Breeds, Long> {
    Breeds findByBreeds(String breeds);
    ArrayList<Breeds> findAll();
}
