package com.neural.network.service;


import com.neural.network.dao.UuidRepository;
import com.neural.network.entity.Uuid;
import org.springframework.stereotype.Service;

@Service("UuidService")
public class UuidServiceImpl implements UuidService {

    private final UuidRepository uuidRepository;

    public UuidServiceImpl(UuidRepository uuidRepository) {
        this.uuidRepository = uuidRepository;
    }

    @Override
    public Uuid findById(long id) {
        return uuidRepository.findById(id);
    }

    @Override
    public Uuid save(Uuid uuid) {
        return uuidRepository.saveAndFlush(uuid);
    }
}
