package com.sda.gui.service;

import com.sda.gui.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

@Service
public class CatApi {

    public static final String CATS_URL = "http://localhost:8080/cats";
    private final RestTemplate restTemplate;




    @Autowired
    public CatApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
   public List<Cat> getCats ()  {
        ResponseEntity<Cat[]> response = restTemplate.exchange(CATS_URL,
                HttpMethod.GET, new HttpEntity<>(null),Cat[].class);
            Cat[] responseBody = response.getBody();
            return Arrays.asList(responseBody);
    }

    public void saveCat(Cat cat) {
        restTemplate.exchange(CATS_URL,POST,
                new HttpEntity<>(cat,null),Object.class);
    }
}


