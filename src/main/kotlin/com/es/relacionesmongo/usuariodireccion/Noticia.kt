package com.es.relacionesmongo.usuariodireccion

import java.sql.Date

data class Noticia(
    val titulo: String,
    val cuerpo: String,
    val fecha_pub: Date,
    val tag: List<String>,
    val user: String
)
