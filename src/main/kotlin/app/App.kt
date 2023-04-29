package app

import product.Organization
import product.OrganizationType
import product.Product
import java.util.TreeMap

class App {
   fun start(){
       val map1 = TreeMap<Int,Int>()
       map1.put(1,1)
       map1.put(2,1)

       val map2 = map1.toMutableMap() as TreeMap<Int,Int>
       map2[1] = 10

       for (i in map1.keys){
           println(map1[i])
       }

       for (i in map2.keys){
           println(map2[i])
       }
       println(map2.javaClass)




    }
}