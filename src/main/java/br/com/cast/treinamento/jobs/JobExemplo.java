package br.com.cast.treinamento.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobExemplo {

    @Scheduled(cron = "0 0/1 * * * *")
    public void tarefaExemplo(){
        System.out.println("Exemplo de Job executando a cada um minuto.");
    }
}
