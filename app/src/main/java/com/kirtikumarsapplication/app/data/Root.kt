package com.example.compliancereporthomefinance

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder


/**
 * Created by brain_atul.a on 07-10-2023.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder("type", "parameters")
class DataSource {
    private var type: String? = null
    private var parameters: Parameters? = null
    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun getParameters(): Parameters? {
        return parameters
    }

    fun setParameters(parameters: Parameters?) {
        this.parameters = parameters
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder("role", "content")
class Message {
    var role: String? = null
    var content: String? = null
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder("endpoint", "key", "indexName")
class Parameters {
    var endpoint: String? = null
    var key: String? = null
    var indexName: String? = null
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder("dataSources", "messages")
class Root {
    var dataSources: List<DataSource> = ArrayList()
    var messages: List<Message> = ArrayList()
}