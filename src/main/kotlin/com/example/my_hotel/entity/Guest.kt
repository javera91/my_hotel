package com.example.my_hotel.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "guest")

class Guest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column (unique = true, nullable = false)
    var nui: String? = null
    var fullName: String? = null
    var address: String? = null
    var email: String? = null


}