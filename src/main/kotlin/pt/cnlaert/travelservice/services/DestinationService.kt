package pt.cnlaert.travelservice.services

import org.springframework.stereotype.Service
import pt.cnlaert.travelservice.exceptions.NotFoundException
import pt.cnlaert.travelservice.model.Destination
import pt.cnlaert.travelservice.model.dto.DestinationDTO
import pt.cnlaert.travelservice.repositories.DestinationRepository

@Service
class DestinationService(
        private val destinationRepository: DestinationRepository,
) {

    fun getAllDestinations(): List<DestinationDTO> {
        return destinationRepository.findAll().
        map{ destination ->
            DestinationDTO(destination.id,
                    destination.name,
                    destination.longitude,
                    destination.latitude,
            ) }.toList()
    }

    fun getByName(name: String): DestinationDTO {
        val destination = destinationRepository.findByName(name)
        if (destination != null) {
            return DestinationDTO(destination.id,
                    destination.name,
                    destination.longitude,
                    destination.latitude,)
        }
        throw NotFoundException("destination not found.")
    }

    fun createOrUpdateDestination(destinationDTO: DestinationDTO): String {
        val destination = Destination(
                id = destinationDTO.id,
                name = destinationDTO.name,
                longitude = destinationDTO.longitude,
                latitude = destinationDTO.latitude,
        )
        return destinationRepository.save(destination).id!!
    }

    fun deleteDestination(id: String) {
        destinationRepository.deleteById(id)
    }
}