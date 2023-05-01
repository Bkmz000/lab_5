package app.command.collection

import app.collection.ProductCollection
import product.Product
import java.util.TreeMap

abstract class ProductCollectionCommand () {

    private var preCommandState = TreeMap<Int, Product>()

    abstract fun execute()

    abstract fun getTypeOfParameter() : Any?

    abstract fun setParameter(param: Any) : Boolean

    fun saveState(){
        preCommandState = TreeMap<Int, Product>(ProductCollection.products)
    }

    fun undo(){
        println("undo $this")
        ProductCollection.products = TreeMap<Int,Product>(preCommandState)
    }
}