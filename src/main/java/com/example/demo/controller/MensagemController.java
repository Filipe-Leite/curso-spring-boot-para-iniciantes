package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CompanyService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api")
public class MensagemController {
    
    private final CompanyService mensagemService;

    public MensagemController(CompanyService mensagemService){
        this.mensagemService = mensagemService;
    }

    @GetMapping("/mensagem")
    public JsonNode mensagem(){


        String jsonString = "{\"nome\": \"João\", \"idade\": 30}";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            JsonNode nome = jsonNode;
        
            return nome;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

        // return mensagemService.obterMensagem();
    }
}
