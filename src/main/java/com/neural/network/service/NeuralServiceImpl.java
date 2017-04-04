package com.neural.network.service;

import com.neural.network.entity.Data;
import com.neural.network.jpclient.PyResult;
import com.neural.network.jpclient.PyServeContext;
import com.neural.network.jpclient.PyServeException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;


@Service("NeuralNetwork")
public class NeuralServiceImpl implements NeuralService {
    public Data neural(String name, String url) throws PyServeException, IOException {
        PyServeContext.init("127.0.0.1", 8888);
        String script = "import neural as nn\n"
                + "url =\"" + url + "\" \n"
                + "name =\"" + name + "\" \n"
                + "nn.download(url, name)\n"
                + "_result_ = nn.begin(name)";
        PyResult rs = PyServeContext.getExecutor().exec(script);
        String result;

        if (rs.isSuccess()) {
            result = rs.getResult();
            String[] allResults = result.split("\"", 0);
            String[] answer = allResults[1].split(",", 0);
            String breedName = answer[0];
            String score = answer[1];
            String uuID = UUID.randomUUID().toString();
            String linkToUploadFoto = url;
            Data data = new Data(breedName, score, uuID, linkToUploadFoto);
            return data;
        } else {
            result = "Execute python script failed: " + rs.getMsg();
            System.out.println(result);
            return null;
        }

    }

    @Override
    public Data faceRec(String name, String url) throws PyServeException {
        PyServeContext.init("127.0.0.1", 8888);
        String script = "import neural as nn\n"
                + "url =\"" + url + "\" \n"
                + "name =\"" + name + "\" \n"
                + "nn.downloadFace(url, name)\n"
                + "_result_ = nn.facerec(name)";
        PyResult rs = PyServeContext.getExecutor().exec(script);
        String result;

        if (rs.isSuccess()) {
            result = rs.getResult();
            String[] allResults = result.split("\"", 0);
            String breedName = "your foto";
            String score = "0";
            String uuID = UUID.randomUUID().toString();
            Data data = new Data(breedName, score, uuID, allResults[1]);
            return data;
        } else {
            result = "Execute python script failed: " + rs.getMsg();
            System.out.println(result);
            return null;
        }
    }

    @Override
    public Data getStyle(String name, String url) throws PyServeException {
        PyServeContext.init("127.0.0.1", 8888);
        String script = "import style as s\n"
                + "import neural as nn\n"
                + "url =\"" + url + "\" \n"
                + "name =\"" + name + "\" \n"
                + "nn.downloadStyle(url, name)\n"
                + "_result_ = s.makeStyle(name)";
        PyResult rs = PyServeContext.getExecutor().exec(script);
        String result;
        if (rs.isSuccess()) {
            result = rs.getResult();
            String[] allResults = result.split("\"", 0);
            String breedName = "your Style foto";
            String score = "0";
            String uuID = UUID.randomUUID().toString();
            Data data = new Data(breedName, score, uuID, allResults[1]);
            return data;
        } else {
            result = "Execute python script failed: " + rs.getMsg();
            System.out.println(result);
            return null;
        }


    }
}
