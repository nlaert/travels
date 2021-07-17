package pt.cnlaert.travelservice.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import pt.cnlaert.travelservice.model.Destination

@Repository
interface DestinationRepository: MongoRepository<Destination, String> {
    fun findByName(name: String): Destination?
}