package com.ptc.challenge.domain.entity

data class SessionEntity(

    var id: String? = null,
    var expire: String? = null,
    var token: String? = null
)