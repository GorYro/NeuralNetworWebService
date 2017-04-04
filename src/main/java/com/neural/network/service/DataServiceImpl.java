package com.neural.network.service;


import com.neural.network.dao.DataRepository;
import com.neural.network.entity.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("DataService")
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    @Override
    public ArrayList<Data> findByUuid(String uuid) {
        return dataRepository.findByUuid(uuid);

    }

    @Override
    public ArrayList<Data> saveAll(ArrayList<Data> allData) {

        for (int i = 0; i < allData.size(); i++) {

            Data data = new Data(allData.get(i).getBreeds(),allData.get(i).getScore(),allData.get(i).getUuid(),allData.get(i).getLink());
            System.out.println(data);
            dataRepository.saveAndFlush(data);
        }
        return allData;
    }

    @Override
    public Data save(Data data) {
        return dataRepository.saveAndFlush(data);
    }

    @Override
    public Data findById(long id) {
        return dataRepository.findById(id);
    }
}
