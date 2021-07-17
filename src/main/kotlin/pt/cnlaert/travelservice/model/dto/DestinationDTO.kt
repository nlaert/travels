package pt.cnlaert.travelservice.model.dto

import org.bson.types.ObjectId

data class DestinationDTO(
        val id: String?,
        val name: String,
        val longitude: String,
        val latitude: String,
)
