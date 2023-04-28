package app.command

import product.Coordinates
import product.UnitOfMeasure

class AddProductInCollection private constructor(
    val name: String,
    val coordinates: Coordinates,
    val price: Int,
    val unitOfMeasure: UnitOfMeasure,
    val manufacturer: UnitOfMeasure,
): Command {
    override fun execute(args: Array<String>) {
        val key = args[0].toInt()
    }


}