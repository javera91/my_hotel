package com.example.my_hotel.controller

import com.example.my_hotel.dto.GiftDto
import com.example.my_hotel.dto.GuestDto
import com.example.my_hotel.entity.Gift
import com.example.my_hotel.entity.Guest
import com.example.my_hotel.service.GiftService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/gifts")
class GiftController {

    @Autowired
    lateinit var giftService: GiftService

    @GetMapping
    fun getGifts() = giftService.getGifts()

    @PostMapping
    fun save(@RequestBody @Valid giftDto: GiftDto): Gift {
        return giftService.save(giftDto)
    }
}