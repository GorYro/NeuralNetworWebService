package com.neural.network.dao;

import com.neural.network.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface DataRepository extends JpaRepository<Data, Long> {
    ArrayList<Data> findByUuid(String uuid);
    Data findById(long id);

}
