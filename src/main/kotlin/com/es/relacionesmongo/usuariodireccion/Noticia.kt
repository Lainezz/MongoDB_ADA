package com.es.relacionesmongo.usuariodireccion

import java.util.Date


data class Noticia(
    val titulo: String,
    val cuerpo: String,
    val fechaPub: Date,
    val tag: List<String>?,
    val user: String // FK
)
