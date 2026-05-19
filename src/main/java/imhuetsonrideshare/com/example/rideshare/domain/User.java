package imhuetsonrideshare.com.example.rideshare.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotBlank
    private String username;

    @Getter
    @Setter
    @NotBlank
    private String password;

    @Getter
    @Setter
    @NotBlank
    private String fullName;

    @Getter
    @Setter
    @Email
    private String email;

    @Getter
    @Setter
    private String role;

    @Getter
    @Setter
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] profileImage;
}
