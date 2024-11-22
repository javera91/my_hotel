package com.example.my_hotel.service

import com.example.my_hotel.dto.GuestDto
import com.example.my_hotel.entity.Guest
import com.example.my_hotel.mapper.GuestMapper
import com.example.my_hotel.repository.GuestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GuestService {

    @Autowired
    lateinit var guestRepository: GuestRepository

    fun getGuests(): List<Guest>{
        return guestRepository.findAll()
    }

    fun save(guestDto: GuestDto): Guest{
        val guest = GuestMapper.toEntity(guestDto)
        return guestRepository.save(guest)
    }
}