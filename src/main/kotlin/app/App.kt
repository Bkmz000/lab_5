package app

import product.Organization
import product.OrganizationType

class App {
    fun start(){
        val org = Organization.Builder()
            .name("Guci")
            .type(OrganizationType.COMMERCIAL)
            .fullName("Prada")
            .build()
        println(org)
    }
}