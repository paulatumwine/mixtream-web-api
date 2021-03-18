package org.mixtream.mixtreamwebapi.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Data
@Document
public class User {
    @Id
    String id;
    String email;
    String password;
    String avatar;
    List<Role> roleList;
}
