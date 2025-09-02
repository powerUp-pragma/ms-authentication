package co.com.crediya.r2dbc;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nationalIdNumber;
    private String firstName;
    private String lastName;
    private String username;
    private String phone;
    private String email;
    private int age;

}
