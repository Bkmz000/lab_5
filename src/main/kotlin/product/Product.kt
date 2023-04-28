package product
import java.time.LocalDateTime


class Product {
    val id: Int
    private val name: String
    private val coordinates: Coordinates
    private val creationDate: LocalDateTime
    private val price: Int
    private val unitOfMeasure: UnitOfMeasure
    private val manufacturer: Organization

    constructor(
        id: Int,
        name: String,
        coordinates: Coordinates,
        price: Int,
        unitOfMeasure: UnitOfMeasure,
        manufacturer: Organization
    ) {
        this.id = id
        this.name = name
        this.coordinates = coordinates
        this.creationDate = LocalDateTime.now()
        this.price = price
        this.unitOfMeasure = unitOfMeasure
        this.manufacturer = manufacturer
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        val prime = 14542343
        return id * prime
    }


}