package hu.indicium.dev.validation

import javax.validation.Validation

object DataValidation {
    fun validate(obj: Any?) {
        val validator = Validation
            .buildDefaultValidatorFactory()
            .validator

        validator.validate(obj).map {
            InvalidField(it.propertyPath.toString(), listOf(it.message))
        }.let {
            if (it.isNotEmpty()) {
                throw ValidationException(it)
            }
        }
    }
}