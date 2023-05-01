package product
import java.time.LocalDateTime
import java.time.ZoneId


class Product private constructor(
    val id: Int,
    val name: String,
    private val coordinates: Coordinates,
    private val creationDate: LocalDateTime,
    private val price: Int,
    private val unitOfMeasure: UnitOfMeasure,
    private val manufacturer: Organization,
){
    data class Builder(
        var name: String? = null,
        var coordinates: Coordinates? = null,
        var creationDate: LocalDateTime? = null,
        var price: Int? = null,
        var unitOfMeasure: UnitOfMeasure? = null,
        var manufacturer: Organization? = null,
    ) {
        fun name(name: String) = apply { this.name = name }
        fun coordinates(coordinates: Coordinates) = apply { this.coordinates = coordinates }
        fun price(price: Int) = apply { this.price = price }
        fun unitOfMeasure(unitOfMeasure: UnitOfMeasure) = apply { this.unitOfMeasure = unitOfMeasure }
        fun manufacturer(manufacturer: Organization) = apply { this.manufacturer = manufacturer }

        private fun isBuildEnough() = !(name.isNullOrEmpty() || coordinates == null || price == null
                || unitOfMeasure == null || manufacturer == null)


        fun build(): Product? {
            return if (isBuildEnough()) {
                val id = LocalDateTime.now().nano - LocalDateTime.of(1900,1,1,1,1).nano
                val currentTime = LocalDateTime.now()
                Product(id,name!!,coordinates!!,currentTime,price!!,unitOfMeasure!!,manufacturer!!)
            } else
                null
        }
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

    override fun toString(): String {
        return """Product(
            |id= $id 
            |name= $name 
            |coordinates= $coordinates 
            |creationDate= $creationDate 
            |price= $price 
            |unitOfMeasure= $unitOfMeasure 
            |manufacturer= $manufacturer)""".trimMargin()
    }


}