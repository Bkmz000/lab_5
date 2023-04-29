package app.collection

import product.Product
import java.util.*

class ProductCollection {
    var products: TreeMap<Int, Product> = TreeMap()

    fun add(product: Product): Unit {
        products[product.id] = product
    }

}