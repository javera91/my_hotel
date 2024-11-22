package com.example.my_hotel.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class GuestDto {

    @NotNull(message = "The nui is required")
    @NotBlank(message = "The nui is required")
    var nui: String? = null

    @NotNull(message = "The full name is required")
    @NotBlank(message = "The full name is required")
    var fullName: String? = null

    @NotNull(message = "The email is required")
    @NotBlank(message = "The email is required")
    var email: String? = null

}