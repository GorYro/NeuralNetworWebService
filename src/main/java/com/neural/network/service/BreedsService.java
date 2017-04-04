package com.neural.network.service;

import com.neural.network.entity.Breeds;

import java.util.ArrayList;

public interface BreedsService {
    Breeds findByBreeds(String breeds);
    ArrayList<Breeds> findAll();
}
