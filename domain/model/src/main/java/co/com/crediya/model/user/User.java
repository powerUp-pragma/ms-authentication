package co.com.crediya.model.user;
import lombok.*;
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
    private int age;





}
