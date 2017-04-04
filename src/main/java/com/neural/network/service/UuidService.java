package com.neural.network.service;


import com.neural.network.entity.Uuid;

public interface UuidService {
    Uuid findById(long id);
    Uuid save(Uuid uuid);
}
