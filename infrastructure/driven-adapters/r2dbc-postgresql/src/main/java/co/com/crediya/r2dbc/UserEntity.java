package co.com.crediya.r2dbc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    private String id;
    private String nationalIdNumber;
    private String firstName;
    private String lastName;
    private String Username;
    private String phone;
    private String email;
    private int age;

}
