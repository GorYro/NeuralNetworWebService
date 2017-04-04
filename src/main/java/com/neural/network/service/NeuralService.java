package com.neural.network.service;

import com.neural.network.entity.Data;
import com.neural.network.jpclient.PyServeException;

import java.io.IOException;

public interface NeuralService {
    public Data neural(String name, String url) throws PyServeException, IOException;

    public Data faceRec(String name, String url) throws PyServeException;

    public Data getStyle (String name, String url) throws PyServeException;
}
