package hu.indicium.dev.rest

import io.micronaut.http.HttpStatus
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class HttpResponse private constructor(
    val status: Number,
    val data: Any,
    val errors: Any,
    val timestamp: LocalDateTime
) {
    data class Builder(
        var status: Number,
        var data: Any? = null,
        var errors: Any? = null
    ) {
        companion object {
            fun ok(): HttpResponse.Builder = HttpResponse.Builder(HttpStatus.OK.code)
            fun created(): HttpResponse.Builder = HttpResponse.Builder(HttpStatus.CREATED.code)
            fun accepted(): HttpResponse.Builder = HttpResponse.Builder(HttpStatus.ACCEPTED.code)
            fun noContent(): HttpResponse.Builder = HttpResponse.Builder(HttpStatus.NO_CONTENT.code)
            fun badRequest(): HttpResponse.Builder = HttpResponse.Builder(HttpStatus.BAD_REQUEST.code)
            fun unauthorized(): HttpResponse.Builder = HttpResponse.Builder(HttpStatus.UNAUTHORIZED.code)
            fun forbidden(): HttpResponse.Builder = HttpResponse.Builder(HttpStatus.FORBIDDEN.code)
            fun notFound(): HttpResponse.Builder = HttpResponse.Builder(HttpStatus.NOT_FOUND.code)
        }

        fun data(data: Any?) = apply { this.data = data }

        fun errors(errors: Any?) = apply { this.errors = errors }

        fun build() = HttpResponse(status, data ?: emptyMap<String, String>(), errors ?: emptyMap<String, String>(), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
    }
}