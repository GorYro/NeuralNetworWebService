package com.neural.network.service;

import com.neural.network.dao.BreedsRepository;
import com.neural.network.entity.Breeds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("BreedsService")
public class BreedsServiceImpl implements BreedsService {

    private final BreedsRepository breedsRepository;

    public BreedsServiceImpl(BreedsRepository breedsRepository) {
        this.breedsRepository = breedsRepository;
    }

    @Override
    public Breeds findByBreeds(String breeds) {
        return breedsRepository.findByBreeds(breeds);
    }

    @Override
    public ArrayList<Breeds> findAll() {
        return breedsRepository.findAll();
    }
}
