package com.example.Medical_store.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    @NotNull(message = "User Id is required")
    private Long userId;

    @NotNull(message = "Total amount is required")
    private Double totalAmount;

    @NotBlank(message = "Order status is required")
    private String status;
}