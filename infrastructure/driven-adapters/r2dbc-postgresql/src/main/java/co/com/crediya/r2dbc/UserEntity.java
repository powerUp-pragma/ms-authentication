package co.com.crediya.r2dbc;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;
import lombok.*;

import java.math.BigInteger;
import java.util.UUID;

@Table("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @Column("user_id")
    private UUID userId;

    private String nationalIdNumber;

    private String firstName;

    private String lastName;

    private String username;

    private String phone;

    private String email;

    private BigInteger salary;

    private int age;
}
