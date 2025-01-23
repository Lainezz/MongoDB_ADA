package com.es.relacionesmongo.usuariodireccion

import com.es.relacionesmongo.ConexionMongo
import com.mongodb.client.MongoCollection

fun main() {

    // Abrir la conexión con la BD
    val database = ConexionMongo.getDatabase("dbada")

    // Obtener la colección
    val collection: MongoCollection<Cliente> = database.getCollection("collUsuarios", Cliente::class.java)

    // Declarar un cliente y una direccion
    val direccion = Direccion("Perdida", "10", "04638", "Mojacar")
    val cliente = Cliente(null, "Pedro", "pedro@gmail.com", listOf("950475192", "677232467"), direccion)

    collection.insertOne(cliente)

    ConexionMongo.close()
}