package com.example.my_hotel.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class GiftDto {

    @NotNull(message = "The description is required")
    @NotBlank(message = "The description is required")
    var description: String? = null

}