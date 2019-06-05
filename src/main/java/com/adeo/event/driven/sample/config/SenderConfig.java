package com.adeo.event.driven.sample.config;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.adeo.event.driven.avro.RecordIn;
import com.adeo.event.driven.avro.RecordOut;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

@Configuration
public class SenderConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put("schema.registry.url", "http://localhost:8081");
        return props;
    }

    @Bean
    public ProducerFactory<String, RecordIn> producerRecordFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, RecordIn> kafkaRecordTemplate() {
        return new KafkaTemplate<>(producerRecordFactory());
    }

    
    @Bean
    public ProducerFactory<String, RecordOut> producerOtherFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, RecordOut> kafkaOtherTemplate() {
        return new KafkaTemplate<>(producerOtherFactory());
    }
}