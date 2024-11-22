package com.example.my_hotel.controller

import com.example.my_hotel.dto.GuestDto
import com.example.my_hotel.entity.Guest
import com.example.my_hotel.service.GuestService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/guests")
class GuestController {

    @Autowired
    lateinit var guestService: GuestService

    @GetMapping
    fun getGuests() = guestService.getGuests()

    @PostMapping
    fun save(@RequestBody @Valid guestDto: GuestDto): Guest{
        return guestService.save(guestDto)
    }
}