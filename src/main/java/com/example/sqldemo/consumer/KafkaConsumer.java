package com.example.sqldemo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.example.sqldemo.config.KafkaConfiguration.DEMO;

@Service
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = DEMO, groupId = "group_id")
    public void consume(Object message) {
        log.info("Listened message : {}", message);
    }
}
