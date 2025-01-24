package com.es.relacionesmongo.usuariodireccion

import com.es.relacionesmongo.ConexionMongo
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters

fun main() {

    // Abrir la conexión con la BD
    val database = ConexionMongo.getDatabase("dbada")

    // Obtener la colección
    val collection: MongoCollection<Cliente> = database.getCollection("collUsuarios", Cliente::class.java)

    try {
        // Declarar un cliente y una direccion
        val direccion = Direccion("alamo", "24", "04638", "Mojacar")
        val cliente = Cliente("maria@gmail.com", "Maria", "mar14", true, listOf("950475656", "666888999"), direccion)

        collection.insertOne(cliente)

        val direccion2 = Direccion("desconocida", "24", "04003", "Almeria")
        val direccion3 = Direccion("principal", "2", "04003", "Almeria")
        val direccion4 = Direccion("principal", "1", "04003", "Almeria")

        val cliente2 = Cliente("pedro@gmail.com", "Pedro", "periko", true, listOf("950475656", "666888999"), direccion2)
        val cliente3 = Cliente("ana@gmail.com", "Ana", "anuski", true, listOf("950475656", "666888999"), direccion3)
        val cliente4 = Cliente("antonio@gmail.com", "Antonio", "toni", true, listOf("950475658", "666888999"), direccion4)
        val cliente5 = Cliente("agustin@gmail.com", "Agustin", "agus", true, listOf("950475656", "666888999"), direccion4)

        val listaClientes = listOf<Cliente>(
            cliente2, cliente3, cliente4, cliente5
        )

        collection.insertMany(listaClientes)
    } catch (e: Exception) {
        println("Clave duplicada")
    }


    // CONSULTAS
    val filtro = Filters.eq("direccion.cp", "04638")

    collection.find(filtro).forEach {
        //println(it)
    }


    // CONSULTA por tlfn
    val filtroTlfn = Filters.eq("telefonos", "950475656")

    collection.find(filtroTlfn).forEach {
        println(it)
    }

    // CONSULTAR COUNT
    val filtroCount = Filters.eq("direccion.cp", "04638")
    println(collection.find(filtroCount).count())
    println(collection.countDocuments(filtroCount))

    // INSERTAR NOTICIAS
    val collNoticias: MongoCollection<Noticia> = database.getCollection("collNoticias", Noticia::class.java)
    //val noticia = Noticia()

    ConexionMongo.close()
}