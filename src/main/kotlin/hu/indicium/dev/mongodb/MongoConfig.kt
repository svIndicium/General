package hu.indicium.dev.mongodb

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("mongodb")
class MongoConfig {
    var database: String? = ""
}