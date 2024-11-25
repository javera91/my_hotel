package com.example.my_hotel.controller

import com.example.my_hotel.dto.GuestDto
import com.example.my_hotel.entity.Guest
import com.example.my_hotel.service.GuestService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @GetMapping("/{id}")
    fun getGuestById(@PathVariable id: Long): Guest {
        return guestService.getGuestById(id)
    }

    @PostMapping
    fun save(@RequestBody @Valid guestDto: GuestDto): Guest{
        return guestService.save(guestDto)
    }

    @PutMapping("/{id}")
    fun updateGuest(@PathVariable id: Long, @RequestBody @Valid guestDto: GuestDto): Guest{
        return guestService.updateGuest(id, guestDto)
    }

    @DeleteMapping("/{id}")
    fun deleteGuest(@PathVariable id: Long) {
        guestService.deleteGuest(id)
    }
}