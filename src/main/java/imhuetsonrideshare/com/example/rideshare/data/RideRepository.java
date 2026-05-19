package imhuetsonrideshare.com.example.rideshare.data;

import imhuetsonrideshare.com.example.rideshare.domain.Ride;
import imhuetsonrideshare.com.example.rideshare.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface RideRepository extends CrudRepository<Ride, Long> {
    List<Ride> findByDriver(User driver);
}
