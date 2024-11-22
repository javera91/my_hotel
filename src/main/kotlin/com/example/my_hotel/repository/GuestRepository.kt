package com.example.my_hotel.repository

import com.example.my_hotel.entity.Guest
import org.springframework.data.jpa.repository.JpaRepository

interface GuestRepository: JpaRepository<Guest, Long> {
}