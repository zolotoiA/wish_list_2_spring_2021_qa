package com.automation.dto;

import lombok.Data;

@Data
public class RegisterResponseDTO {
    private final String jwt;
    private final Long id;
    private final String fullName;
    private final String userName;
}
