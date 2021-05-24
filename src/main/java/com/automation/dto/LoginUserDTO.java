package com.automation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserDTO {
    private final String username;
    private final String password;
}
