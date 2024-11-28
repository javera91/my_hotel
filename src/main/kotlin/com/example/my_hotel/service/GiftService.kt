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

    fun getGiftById(id: Long): Gift {
        return giftRepository.findById(id).orElseThrow {
            throw RuntimeException("Gift not found with id: $id")
        }
    }

    fun updateGift(id: Long, giftDto: GiftDto): Gift {
        val existingGift = getGiftById(id)
        val updateGift = GiftMapper.toEntity(giftDto).apply{
            this.id = existingGift.id
        }
        return giftRepository.save(updateGift)
    }

    fun deleteGift(id: Long) {
        if(!giftRepository.existsById(id)){
            throw RuntimeException("Gift not found with id: $id")
        }
        giftRepository.deleteById(id)
    }
}