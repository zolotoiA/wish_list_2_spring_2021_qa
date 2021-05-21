package com.automation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserDTO {
    private final String fullName;
    private final String username;
    private final String password;
    private final String confirmPassword;

}
