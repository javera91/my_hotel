package com.example.my_hotel.mapper

import com.example.my_hotel.dto.GiftDto
import com.example.my_hotel.entity.Gift


object GiftMapper {

    fun toEntity(giftDto: GiftDto): Gift {
        val gift = Gift()
        gift.description = giftDto.description
        return gift
    }
}