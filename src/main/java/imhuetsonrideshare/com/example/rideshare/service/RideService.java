package imhuetsonrideshare.com.example.rideshare.service;

import imhuetsonrideshare.com.example.rideshare.data.RideRepository;
import imhuetsonrideshare.com.example.rideshare.domain.Ride;
import imhuetsonrideshare.com.example.rideshare.domain.User;
import imhuetsonrideshare.com.example.rideshare.messaging.RideMessage;
import org.springframework.stereotype.Service;

@Service
public class RideService {
    private final RideRepository rideRepo;
    private final RideEventProducer producer;

    public RideService(RideRepository rideRepo, RideEventProducer producer) {
        this.rideRepo = rideRepo;
        this.producer = producer;
    }

    public Ride signupPassenger(Long rideId, User passenger) {
        Ride ride = rideRepo.findById(rideId).orElseThrow();

        ride.getPassengers().add(passenger);

        rideRepo.save(ride);

        RideMessage joinedMessage = new RideMessage(
                passenger.getEmail(),
                "Ride Confirmation",
                "You joined a ride to: "
                    + ride.getDestinationCampus()
        );

        producer.sendRideNotification(joinedMessage);

        if(ride.getPassengers().size() >= ride.getMaxPassengers()) {
            RideMessage fullMessage = new RideMessage(
                    ride.getDriver().getEmail(),
                    "Ride is Full",
                    "Your ride is now full."
            );

            producer.sendRideNotification(fullMessage);
        }
        return ride;
    }

    public void cancelRide(Long rideId) {
        Ride ride = rideRepo.findById(rideId).orElseThrow();

        ride.setCancelled(true);

        rideRepo.save(ride);

        for(User passenger : ride.getPassengers()) {
            RideMessage cancelMessage = new RideMessage(
                    passenger.getEmail(),
                    "Ride is Cancelled",
                    "Your ride has been cancelled."
            );

            producer.sendRideNotification(cancelMessage);
        }
    }
}
