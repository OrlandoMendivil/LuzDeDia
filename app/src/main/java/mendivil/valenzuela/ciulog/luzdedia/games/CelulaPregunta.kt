package mendivil.valenzuela.ciulog.luzdedia.games

data class CelulaPregunta(val id: Int, var pregunta: String, var img: Int, var respuestas: Array<String>, var respuestaCorrecta: Int) {
}