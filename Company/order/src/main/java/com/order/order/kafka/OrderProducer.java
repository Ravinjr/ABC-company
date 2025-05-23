package com.order.order.kafka;

import com.base.base.dto.OrderEventDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventDTO.class);

//    private final NewTopic orderTopic;

    public OrderProducer( KafkaTemplate<String, OrderEventDTO> kafkaTemplate) {
//        this.orderTopic = orderTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    private final KafkaTemplate<String, OrderEventDTO> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;
    public void sendMessage(OrderEventDTO orderEventDTO) {
//        LOGGER.info(String.format("Sending order event to topic %s", orderEventDTO.toString()));

//        Message<OrderEventDTO> message = MessageBuilder
//                .withPayload(orderEventDTO)
//                .setHeader(KafkaHeaders.TOPIC,orderTopic.name())
//                .build();

//        log.info(orderEventDTO.toString());
        LOGGER.info(orderEventDTO.toString());
        kafkaTemplate.send(defaultTopic,orderEventDTO);
    }


}
