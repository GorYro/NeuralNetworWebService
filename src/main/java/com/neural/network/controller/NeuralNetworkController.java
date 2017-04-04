package com.neural.network.controller;

import com.neural.network.entity.Breeds;
import com.neural.network.entity.Data;
import com.neural.network.jpclient.PyServeException;
import com.neural.network.service.BreedsService;
import com.neural.network.service.DataService;
import com.neural.network.service.NeuralServiceImpl;
import com.neural.network.service.UuidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.UUID;

@Controller
public class NeuralNetworkController {

    @Autowired
    NeuralServiceImpl neuralServiceImpl;

    @Autowired
    DataService dataService;

    @Autowired
    UuidService uuidService;

    @Autowired
    BreedsService breedsService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/animals", method = RequestMethod.GET)
    String getAnimals() {
        return "animals";
    }

    @RequestMapping(value = "/face", method = RequestMethod.GET)
    String getFace() {
        return "face";
    }

    @RequestMapping(value = "/style", method = RequestMethod.GET)
    String getStyle() {
        return "style";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    String getResultPage(@RequestParam(value = "url") String url, Model model) throws IOException, PyServeException {
        String name = UUID.randomUUID().toString();
        Data data;
        try {
            data = neuralServiceImpl.neural(name, url);
        }
        catch (Exception e) {
            System.out.println(e);
            return "redirect:/";
        }
        Breeds breeds;
        try {
            breeds = breedsService.findByBreeds(data.getBreeds());
        }
        catch (NullPointerException e2) {
            System.out.println(e2);
            return "redirect:/";
        }
        String imgOrigin = breeds.getLinks();
        dataService.save(data);
        String uploadImg = url;
        model.addAttribute("results", data);
        model.addAttribute("img", uploadImg);
        model.addAttribute("imgOrigin", imgOrigin);
        return "animals-result";
    }

    @RequestMapping(value = "/sendface", method = RequestMethod.POST)
    String getResultFacePage(@RequestParam(value = "url") String url, Model model) throws IOException, PyServeException {
        String name = UUID.randomUUID().toString();
        Data data = neuralServiceImpl.faceRec(name, url);
        String link = "/img/" + data.getLink() + ".jpg";
        model.addAttribute("face", link);
        return "face-result";
    }

    @RequestMapping(value = "/sendstyle", method = RequestMethod.POST)
    String getResultStylePage(@RequestParam(value = "url") String url, Model model) throws IOException, PyServeException {
        String name = UUID.randomUUID().toString();
        Data data = neuralServiceImpl.getStyle(name, url);
        String link = "/img/" + data.getLink() + ".jpg";
        model.addAttribute("style", link);
        return "style-result";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    String getHistory(@PathVariable(value = "id") long id, Model model) throws IOException, PyServeException {
        Data data = dataService.findById(id);
        String uploadImg = data.getLink();
        Breeds breeds = breedsService.findByBreeds(data.getBreeds());
        String imgOrigin = breeds.getLinks();

        model.addAttribute("results", data);
        model.addAttribute("img", uploadImg);
        model.addAttribute("imgOrigin", imgOrigin);
        return "animals-result";
    }


}
