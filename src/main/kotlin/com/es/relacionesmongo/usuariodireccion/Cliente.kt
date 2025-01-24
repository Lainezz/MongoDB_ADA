package com.es.relacionesmongo.usuariodireccion

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty

data class Cliente(
    @BsonId
    val _id: String?, // EMAIL
    val nombre: String,
    val nick: String,
    val estado: Boolean,
    @BsonProperty("telefonos")
    val tlfn: List<String>,
    val direccion: Direccion?
)
