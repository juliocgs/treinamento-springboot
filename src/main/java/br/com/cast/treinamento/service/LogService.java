package br.com.cast.treinamento.service;

import br.com.cast.treinamento.model.Curso;
import br.com.cast.treinamento.model.Log;
import br.com.cast.treinamento.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogService {

    @Autowired
    LogRepository repository;

    public void log(Curso curso, String usuario, String acao){
        repository.save(new Log(usuario, new Date(), curso, acao));
    }
}
