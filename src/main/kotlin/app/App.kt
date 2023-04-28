package app

import product.Organization
import product.OrganizationType
import product.Product

class App {
   fun start(){
        val org = Organization.Builder()
            .name("Guci")
            .type(OrganizationType.COMMERCIAL)
            .fullName("Prada")
        println(org.toString())

        val prod = Product.Builder()
            .name("fdfd")
        println(prod)

    }
}