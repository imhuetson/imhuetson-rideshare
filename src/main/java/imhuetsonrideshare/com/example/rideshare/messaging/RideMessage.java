package imhuetsonrideshare.com.example.rideshare.messaging;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class RideMessage implements Serializable {
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String subject;
    @Getter
    @Setter
    private String message;

    public RideMessage() {}

    public RideMessage(String email, String subject, String message) {
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

}
