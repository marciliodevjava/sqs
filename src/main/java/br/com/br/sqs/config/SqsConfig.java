package br.com.br.sqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

@Configuration
public class SqsConfig {

    @Value("${cloud.aws.endpoint}")
    private String awsEndpoint;

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .region(Region.US_EAST_1) // Configure a região desejada
                .endpointOverride(URI.create(awsEndpoint))
                .build();
    }
}


