package org.mixtream.mixtreamwebapi.dto;

import lombok.Builder;
import lombok.Data;
import org.mixtream.mixtreamwebapi.model.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
public class UserDTO {
    String id;
    @NotBlank
    String email;
    String password;
    String avatar;
    List<Role> roleList;
}
