package co.com.crediya.model.role;
import lombok.*;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Role {

    private String roleId;
    private String name;
    private String description;


}
