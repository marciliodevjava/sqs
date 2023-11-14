package br.com.br.sqs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsService {

    @Autowired
    private SqsClient sqsClient;

    @Value("${sqs.contratacao}")
    private String contratacaoQueue;

    @Value("${sqs.bemVindo}")
    private String bemVindoQueue;

    public void sendMessageContratacao(String messageBody) {
        try {
            sendMessage(contratacaoQueue, messageBody);
        } catch (Exception e){
            System.out.println("Aconteceu um erro no enviou da mensagem de Contratacao");
        }
    }

    public void sendMessageBemVindo(String messageBody) {
        try {
        sendMessage(bemVindoQueue, messageBody);
        } catch (Exception e){
            System.out.println("Aconteceu um erro no enviou da mensagem de Contratacao");
        }
    }

    private void sendMessage(String queueUrl, String messageBody) {
        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(messageBody)
                .build();

        sqsClient.sendMessage(request);
    }
}