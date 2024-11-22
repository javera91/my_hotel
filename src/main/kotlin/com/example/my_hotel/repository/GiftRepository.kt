package com.example.my_hotel.repository

import com.example.my_hotel.entity.Gift
import org.springframework.data.jpa.repository.JpaRepository

interface GiftRepository: JpaRepository<Gift, Long> {
}