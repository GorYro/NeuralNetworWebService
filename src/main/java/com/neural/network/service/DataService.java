package com.neural.network.service;


import com.neural.network.entity.Data;

import java.util.ArrayList;

public interface DataService {
    ArrayList<Data> findByUuid(String uuid);
    ArrayList<Data> saveAll (ArrayList<Data> allData);
    Data save (Data data);
    Data findById (long id);
}
