package pt.cnlaert.travelservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("destinations")
data class Destination(
        @Id
        val id: String?,
        val name: String,
        val longitude: String,
        val latitude: String,
)
