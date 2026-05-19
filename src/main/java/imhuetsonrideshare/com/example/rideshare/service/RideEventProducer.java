package imhuetsonrideshare.com.example.rideshare.service;

import imhuetsonrideshare.com.example.rideshare.api.RabbitConfig;
import imhuetsonrideshare.com.example.rideshare.messaging.RideMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RideEventProducer {
    private final RabbitTemplate rabbitTemplate;

    public RideEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendRideNotification(RideMessage rideMessage) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE, rideMessage);

    }
}
