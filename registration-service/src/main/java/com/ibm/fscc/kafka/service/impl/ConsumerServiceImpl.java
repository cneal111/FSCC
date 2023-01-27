package com.ibm.fscc.kafka.service.impl;

import com.ibm.fscc.kafka.config.KafkaConfig;
import com.ibm.fscc.kafka.service.ConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Properties;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;


@Component
public class ConsumerServiceImpl implements ConsumerService {
    // @Autowired
    KafkaConsumer<String,String> kafkaConsumer;

    @KafkaListener(topics="registration-topic",groupId = "group-id-1")


    @Override
    public void consume(String msg) {


    }
}
