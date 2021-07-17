package pt.cnlaert.travelservice.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.cnlaert.travelservice.model.dto.DestinationDTO
import pt.cnlaert.travelservice.services.DestinationService

@RestController
@RequestMapping("/destination")
class DestinationController(val destinationService: DestinationService) {

    @GetMapping
    fun getDestination(@RequestParam name: String?): ResponseEntity<Any> {
        if (name != null) {
            return ResponseEntity.ok(destinationService.getByName(name))
        }
        return ResponseEntity.ok(destinationService.getAllDestinations())
    }

    @PostMapping
    fun createDestination(@RequestBody destinationDTO: DestinationDTO): ResponseEntity<Any> {
        destinationService.createOrUpdateDestination(destinationDTO)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PutMapping
    fun updateDestination(@RequestBody destinationDTO: DestinationDTO): ResponseEntity<Any> {
        destinationService.createOrUpdateDestination(destinationDTO)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @DeleteMapping("/{id}")
    fun deleteDestination(@PathVariable id: String): ResponseEntity<Any> {
        destinationService.deleteDestination(id)
        return ResponseEntity.ok().build()
    }
}