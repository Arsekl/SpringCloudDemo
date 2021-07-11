package AdminService;
import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserVO {
    @NotBlank(message = "name can not be blank")
    String name;
    @NotBlank(message = "password can not be blank")
    String passwd;
}