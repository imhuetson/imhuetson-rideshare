package imhuetsonrideshare.com.example.rideshare.data;

import imhuetsonrideshare.com.example.rideshare.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
