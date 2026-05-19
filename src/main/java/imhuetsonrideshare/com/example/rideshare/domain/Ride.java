package imhuetsonrideshare.com.example.rideshare.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String pickupLocation;

    @Getter
    @Setter
    @NotBlank
    private String destinationCampus;

    @Getter
    @Setter
    @FutureOrPresent
    private LocalDate rideDate;

    @Getter
    @Setter
    private LocalTime rideTime;

    @Getter
    @Setter
    @Min(1)
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

    @Getter
    @Setter
    private boolean completed;
}
