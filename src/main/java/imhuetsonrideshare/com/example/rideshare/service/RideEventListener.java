package imhuetsonrideshare.com.example.rideshare.service;

import imhuetsonrideshare.com.example.rideshare.api.RabbitConfig;
import imhuetsonrideshare.com.example.rideshare.messaging.RideMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RideEventListener {
    private final EmailService emailService;

    public RideEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receiveMessage(RideMessage rideMessage) {
        System.out.println("Ride Message Received: " + rideMessage.getSubject());

        emailService.sendEmail(
                rideMessage.getEmail(),
                rideMessage.getSubject(),
                rideMessage.getMessage()
        );
    }

}
