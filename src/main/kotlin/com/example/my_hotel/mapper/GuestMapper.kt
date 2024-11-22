package com.example.my_hotel.mapper

import com.example.my_hotel.dto.GuestDto
import com.example.my_hotel.entity.Guest

object GuestMapper {

    fun toEntity(guestDto: GuestDto): Guest {
        val guest = Guest()
        guest.nui = guestDto.nui
        guest.fullName = guestDto.fullName
        guest.email = guestDto.email
        return guest
    }
}