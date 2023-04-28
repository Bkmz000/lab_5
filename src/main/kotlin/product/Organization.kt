package product

import java.time.LocalDateTime

class Organization private constructor(
    private val id: Int,
    private val name: String,
    private val fullName: String,
    private val type: OrganizationType = OrganizationType.COMMERCIAL){

    data class Builder(
        private var id: Int = LocalDateTime.now().second,
        private var name: String? = null,
        private var fullName: String? = null,
        private var type: OrganizationType? = null,
    ){
        fun name(name: String) = apply { this.name = name }
        fun fullName(fullName: String) = apply { this.fullName = fullName }
        fun type(type: OrganizationType) = apply { this.type = type }

        private fun isBuildEnough(): Boolean {
            return !(name.isNullOrEmpty() || fullName.isNullOrEmpty() || type == null )
        }

        fun build() {
            if (isBuildEnough()) Organization(id ,name!!,fullName!!,type!!) else null
        }
    }




    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Organization

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        val prime = 345353
        return id * prime
    }
}