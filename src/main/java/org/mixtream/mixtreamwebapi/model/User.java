package org.mixtream.mixtreamwebapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class User {
    String email;
    String password;
    String avatar;
    List<Role> roleList;
}
