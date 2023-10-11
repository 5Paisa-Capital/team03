package com.example.compliancereporthomefinance

/**
 * Created by brain_atul.a on 07-10-2023.
 */
import com.fasterxml.jackson.annotation.JsonProperty

data class ResponseData (

    @field:JsonProperty("created")
    var created: Int? = null,

    @field:JsonProperty("model")
    var model: String? = null,

    @field:JsonProperty("id")
    var id: String? = null,

    @field:JsonProperty("choices")
    var choices: List<ChoicesItem?>? = null,

    @field:JsonProperty("object")
    var obj: String? = null
)

data class MessagesItem(

    @field:JsonProperty("role")
    var role: String? = null,

    @field:JsonProperty("index")
    var index: Int? = null,

    @field:JsonProperty("end_turn")
    var endTurn: Boolean? = null,

    @field:JsonProperty("content")
    var content: String? = null
)

data class ChoicesItem(

    @field:JsonProperty("index")
    var index: Int? = null,

    @field:JsonProperty("messages")
    var messages: List<MessagesItem?>? = null
)