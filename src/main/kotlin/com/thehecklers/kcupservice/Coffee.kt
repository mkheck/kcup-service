package com.thehecklers.kcupservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
data class Coffee constructor(@Id val id: String? = null, val type: String = "Any old Joe") {
    var code = this.type.toLowerCase().replace(" ", "-")

    override fun toString() = "Coffee{id=$id, type=$type, code=$code}"
}
