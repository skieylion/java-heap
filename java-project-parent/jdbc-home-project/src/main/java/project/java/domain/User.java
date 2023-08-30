package project.java.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String fullName;
    private UserRole role;
}