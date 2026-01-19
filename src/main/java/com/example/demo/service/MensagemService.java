package com.example.demo.service;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.MensagemRepository;;

@Repository
public class MensagemService {
    
    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem(){
        return mensagemRepository.obterMensagem();
    }
}
