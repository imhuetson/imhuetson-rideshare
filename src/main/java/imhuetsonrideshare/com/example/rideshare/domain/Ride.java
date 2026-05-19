package imhuetsonrideshare.com.example.rideshare.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickupLocation;

    private String destinationCampus;

    private LocalDate rideDate;

    private LocalTime rideTime;

    private int maxPassengers;

    private boolean cancelled;

    @ManyToOne
    private User driver;

    @ManyToMany
    private List<User> passengers = new ArrayList<>();
}
