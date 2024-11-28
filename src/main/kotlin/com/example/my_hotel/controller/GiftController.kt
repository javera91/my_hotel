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

    @GetMapping("/{id}")
    fun getGiftById(@PathVariable id: Long): Gift {
        return giftService.getGiftById(id)
    }

    @PostMapping
    fun save(@RequestBody @Valid giftDto: GiftDto): Gift {
        return giftService.save(giftDto)
    }

    @PutMapping("/{id}")
    fun updateGift(@PathVariable id: Long, @RequestBody @Valid giftDto: GiftDto): Gift {
        return giftService.updateGift(id, giftDto)
    }

    @DeleteMapping("/{id}")
    fun deleteGift(@PathVariable id: Long) {
        giftService.deleteGift(id)
    }
}