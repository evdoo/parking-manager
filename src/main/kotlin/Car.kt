package main.kotlin

data class Car(
    val brand: String,
    val color: String,
    val number: String,
    val owner: Owner
) {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Car) return false
        return (other.number == this.number
                && (other.owner == this.owner))
    }

    override fun hashCode(): Int = number.hashCode() + owner.hashCode()

    override fun toString(): String = "$color $brand, номер $number"
}