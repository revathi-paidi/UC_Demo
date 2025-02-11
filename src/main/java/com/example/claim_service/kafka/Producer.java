package com.example.claim_service.kafka;

import com.example.claim_service.dto.EmployerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {
//    private final KafkaTemplate<String, EmployerResponseDto> kafkaTemplate;
//
//    public void sendClaimEvent(EmployerResponseDto responseDto) {
//        kafkaTemplate.send("employer-response-topic", responseDto);
//        System.out.println("Sent claim event: " + responseDto);
//    }
       private final KafkaTemplate<String, Object> kafkaTemplate;

       public void sendMessage(String topic, Object message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Sent Kafka message: " + message);
        System.out.println("Sent Kafka message to topic: " + topic);
        }
}
