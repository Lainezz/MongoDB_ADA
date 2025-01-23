package com.es.relacionesmongo.usuariodireccion

data class Cliente(
    val _id: String?,
    val nombre: String,
    val email: String,
    val tlfn: List<String>,
    val direccion: Direccion?
)
