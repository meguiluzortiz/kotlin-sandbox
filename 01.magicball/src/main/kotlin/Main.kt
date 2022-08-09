// Declaramos los valores de nuestras respuestas
const val AFIRMATIVE_RESPONSE = "✅"
const val NEGATIVE_RESPONSE = "❌"
const val DOUBT_RESPONSE = "\uD83E\uDD14"

//Unimos las respuestas con los valores
val answers = mapOf(
    "Sí" to AFIRMATIVE_RESPONSE,
    "Es cierto" to AFIRMATIVE_RESPONSE,
    "Totalmente" to AFIRMATIVE_RESPONSE,
    "Sin duda" to AFIRMATIVE_RESPONSE,
    "Pregunta en otro momento" to DOUBT_RESPONSE,
    "No puedo decirte en este momento" to DOUBT_RESPONSE,
    "Puede que si o puede que no" to DOUBT_RESPONSE,
    "No va a suceder" to NEGATIVE_RESPONSE,
    "No cuentes con ello" to NEGATIVE_RESPONSE,
    "Definitivamente no" to NEGATIVE_RESPONSE,
    "No lo creo" to NEGATIVE_RESPONSE,
)

fun main() {
    // Declarar el mensaje de entrada del programa
    println("Hola soy tu bola 8 magica creada en Kotlin. ¿Cual de estas opciones deseas realizar? ")
    println("1. Realizar una pregunta.")
    println("2. Revisar todas las respuestas.")
    println("3. Salir")

    // Obtener el valor del usuario y convertirlo a un entero nullable
    val insertedValue = readLine()

    // Dependiendo del numero utilizamos el when para realizar una acción.
    when (insertedValue){
        "1" -> askAQuestion()
        "2" -> showAnswers()
        "3" -> quit()
        else -> showError()
    }

}

//Mostramos un error por pantalla
fun showError() {
    println("Vaya... parece que has elegido una opción no valida, intenta de nuevo.")
}

//Mostramos un mensaje de despedida por pantalla
fun quit() {
    println("¡Hasta luego!")
}

//Mostramos un menu para seleccionar una de las opciones al usuario
fun showAnswers() {
    println("Selecciona una opción")
    println("1. Revisar todas las respuestas")
    println("2. Revisar solo las respuestas afirmativas")
    println("3. Revisar solo las respuestas dudodas")
    println("4. Revisar solo las respuestas negativas")

    val opcionIngresada = readLine()?.toInt()
    when(opcionIngresada){
        1 ->  mostrarRespuestasPorTipo()
        2 -> mostrarRespuestasPorTipo(tipoDeRespuesta = AFIRMATIVE_RESPONSE)
        3 -> mostrarRespuestasPorTipo(tipoDeRespuesta = DOUBT_RESPONSE)
        4 -> mostrarRespuestasPorTipo(tipoDeRespuesta = NEGATIVE_RESPONSE)
        else -> println("Respuesta no valida, adios.")
    }

}

// Mostramos las respuestas dependiendo del tipo que se pase como parametro
fun mostrarRespuestasPorTipo(tipoDeRespuesta : String = "TODOS") {
    when (tipoDeRespuesta){
        "TODOS" -> answers.keys.forEach { respuesta -> println(respuesta) }
        AFIRMATIVE_RESPONSE -> answers.filterValues { values -> values == AFIRMATIVE_RESPONSE }
            .also { respuestasPositivas -> println(respuestasPositivas.keys) }

        NEGATIVE_RESPONSE -> answers.filterValues { values -> values == NEGATIVE_RESPONSE }
            .also { respuestasNegativas -> println(respuestasNegativas.keys) }

        DOUBT_RESPONSE -> answers.filterValues { values -> values == DOUBT_RESPONSE }
            .also { respuestasDudosas -> println(respuestasDudosas.keys) }
    }
}

// Preguntamos al usuario que deberiamos mostrarle y le mostramos una respuesta al azar
fun askAQuestion() {
    println("¿Que preguntas deseas realizar?")
    readLine()
    println("Asi que esa es tu pregunta... La respuesta a eso es:")
    val respuestaGenerada = answers.keys.random()
    println(respuestaGenerada)
}
