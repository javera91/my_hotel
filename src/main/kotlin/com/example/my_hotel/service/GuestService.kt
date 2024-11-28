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
    lateinit var guestRepository: GuestRepository // Inyección de dependencia del repositorio

    fun getGuests(): List<Guest>{
        return guestRepository.findAll() // Llama al repositorio para obtener todos los huéspedes
    }

    fun save(guestDto: GuestDto): Guest{
        val guest = GuestMapper.toEntity(guestDto)
        return guestRepository.save(guest) // Guarda el huésped en la base de datos
    }

    fun getGuestById(id: Long): Guest{
        // Busca el huésped por su ID y lanza una excepción si no se encuentra
        return guestRepository.findById(id).orElseThrow {
            throw RuntimeException("Guest not found with id: $id")
        }
    }

    fun updateGuest(id: Long, guestDto: GuestDto): Guest{
        val existingGuest = getGuestById(id) // Verifica si el huésped existe antes de actualizar
        val updateGuest = GuestMapper.toEntity(guestDto).apply { // Convierte el GuestDto a una entidad Guest y mantiene el ID existente
            this.id = existingGuest.id // Preserva el ID del huésped existente
        }
        return guestRepository.save(updateGuest) // Guarda el huésped actualizado en la base de datos
    }

    fun deleteGuest(id: Long){
        // Verifica si el huésped existe antes de intentar eliminarlo
        if (!guestRepository.existsById(id)){
            throw RuntimeException("Guest not found with id: $id")
        }
        guestRepository.deleteById(id) // Elimina el huésped de la base de datos
    }
}