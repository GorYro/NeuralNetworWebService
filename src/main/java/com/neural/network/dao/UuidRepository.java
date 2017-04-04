package com.neural.network.dao;

import com.neural.network.entity.Uuid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UuidRepository extends JpaRepository<Uuid, Long> {
    Uuid findById(long id);
}
