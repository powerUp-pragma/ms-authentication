package co.com.crediya.r2dbc;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.*;

@Table("users")             // nombre de la tabla en la BD
@Data                       // getters, setters, equals, hashCode, toString
@NoArgsConstructor          // constructor vacío
@AllArgsConstructor         // constructor con todos los campos
@Builder                    // patrón Builder
public class UserEntity {

    @Id
    private String id;

    private String nationalIdNumber;

    private String firstName;

    private String lastName;

    private String username;

    private String phone;

    private String email;

    private int age;
}
