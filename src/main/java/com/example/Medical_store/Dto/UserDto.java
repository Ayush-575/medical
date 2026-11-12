package com.example.Medical_store.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must contain at least 6 characters")
    private String password;

//    @NotBlank(message = "Name is required")
//    private String name;
//
//    @Pattern(
//            regexp = "^[0-9]{10}$",
//            message = "Mobile number must be 10 digits"
//    )
//    private String mobileNumber;
//
//    @NotBlank(message = "Address is required")
//    private String address;
}