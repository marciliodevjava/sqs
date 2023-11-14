package br.com.br.sqs.resource;

import br.com.br.sqs.dto.CepDto;
import br.com.br.sqs.service.SqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SqsController {

    @Autowired
    private SqsService sqsService;

    @PostMapping("/send-message")
    public String sendMessage(@RequestBody CepDto cep) {
        sqsService.sendMessageContratacao(cep.getCep());
        sqsService.sendMessageBemVindo(cep.getCep());
        return "Message sent successfully!";
    }
}