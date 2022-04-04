package hu.indicium.dev.validation

class ValidationException(invalidFields: List<InvalidField>): Exception("Invalid request: \n${ invalidFields.joinToString("\n") }") {
}