package imhuetsonrideshare.com.example.rideshare.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ride {

    @jakarta.persistence.Id
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String pickupLocation;

    @Getter
    @Setter
    private String destinationCampus;

    @Getter
    @Setter
    private LocalDate rideDate;

    @Getter
    @Setter
    private LocalTime rideTime;

    @Getter
    @Setter
    private int maxPassengers;

    @Getter
    @Setter
    private boolean cancelled;

    @Getter
    @Setter
    @ManyToOne
    private User driver;

    @Getter
    @Setter
    @ManyToMany
    private List<User> passengers = new ArrayList<>();
}
