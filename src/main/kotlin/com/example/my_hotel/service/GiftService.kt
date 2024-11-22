package com.example.my_hotel.service

import com.example.my_hotel.dto.GiftDto
import com.example.my_hotel.entity.Gift
import com.example.my_hotel.mapper.GiftMapper
import com.example.my_hotel.repository.GiftRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GiftService {

    @Autowired
    lateinit var giftRepository: GiftRepository

    fun getGifts(): List<Gift>{
        return giftRepository.findAll()
    }

    fun save(giftDto: GiftDto): Gift {
        val gift = GiftMapper.toEntity(giftDto)
        return giftRepository.save(gift)
    }
}