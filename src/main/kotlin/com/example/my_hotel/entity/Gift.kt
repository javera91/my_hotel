package com.example.my_hotel.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "gift")

class Gift {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var description: String? = null
    var expirationDate: LocalDate? = null
    var guestId: Long? = null
}