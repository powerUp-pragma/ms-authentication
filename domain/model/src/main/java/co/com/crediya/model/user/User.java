package co.com.crediya.model.user;
import co.com.crediya.model.role.Role;
import lombok.*;

import java.math.BigInteger;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {

    private String id;
    private String nationalIdNumber;
    private String firstName;
    private String lastName;
    private String username;
    private String phone;
    private String email;
    private BigInteger salary;
    private Role role;
    private int age;

}
