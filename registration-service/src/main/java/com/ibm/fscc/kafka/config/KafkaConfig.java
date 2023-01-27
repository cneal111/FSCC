package com.ibm.fscc.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import java.lang.reflect.Constructor;
import java.util.Properties;

@Configuration
public class KafkaConfig {

    Properties config = new Properties();
    // TODO - implement remaining properties

    private final static String TOPIC = "registration-topic";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092";
    private final static String API_KEY = "MY_API_KEY";

    private String topic = null;
    private String bootstrapServers = null;
    private String apiKey = null;


    public KafkaConfig(){
        topic = System.getenv(TOPIC);
        bootstrapServers = System.getenv(BOOTSTRAP_SERVERS);
        apiKey = System.getenv(API_KEY);

    }

    public String getTopic(){
        return topic;
    }

    public Properties getProducerConfigs(){
        Properties props = new Properties();
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "registration-producer");
        props.put(ProducerConfig.ACKS_CONFIG,"all");

        return props;
    }


    public Properties getConsumerConfigs(){
        Properties props = new Properties();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "registration-consumer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.CLIENT_DNS_LOOKUP_CONFIG, "use_all_dns_ips");

        return props;
    }
}
