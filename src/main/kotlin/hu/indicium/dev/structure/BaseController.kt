package hu.indicium.dev.structure

import hu.indicium.dev.validation.DataValidation

abstract class BaseController {
    fun validate(data: Any) {
        DataValidation.validate(data)
    }
}