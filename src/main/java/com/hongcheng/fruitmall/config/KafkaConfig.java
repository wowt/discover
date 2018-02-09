package com.hongcheng.fruitmall.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * Kafka config
 */
@SpringBootConfiguration
public class KafkaConfig {

    @Value("${kafka.server}")
    private String server;

    @Bean("kafkaEventProducer")
    public KafkaProducer<String,String> kafkaEventProducer() {
        Properties kafkaConfig = new Properties();
        kafkaConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,server);
        // max block time when fetch meta data
        kafkaConfig.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 3000);
        kafkaConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        kafkaConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(kafkaConfig);
    }
}
