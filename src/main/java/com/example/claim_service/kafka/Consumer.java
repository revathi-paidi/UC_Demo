package com.example.claim_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "claim-status-update-topic", groupId = "claim-service-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(Object message) {
        logger.info("Received message from Kafka: {}", message);
    }
}
