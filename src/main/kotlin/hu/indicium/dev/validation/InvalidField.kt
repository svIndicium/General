package hu.indicium.dev.validation

data class InvalidField (
    val field: String,
    val errors: List<String>
    ) {
    override fun toString(): String {
        return "${ field }: ${ errors.joinToString() }"
    }
}