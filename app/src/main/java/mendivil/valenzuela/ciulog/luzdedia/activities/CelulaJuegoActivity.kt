package mendivil.valenzuela.ciulog.luzdedia.activities

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import mendivil.valenzuela.ciulog.luzdedia.R
import mendivil.valenzuela.ciulog.luzdedia.games.CelulaPregunta
import java.security.AccessController.getContext
import java.util.*
import kotlin.concurrent.schedule

class CelulaJuegoActivity : AppCompatActivity() {
    var preguntas: Array<CelulaPregunta> = intializePreguntas()
    var respuestaActual: Int = 0 // Starts at 1, 0 means null
    var preguntaActual: Int = 0
    var canAnswer = false

    // Preguntas
    lateinit var pregunta_tv: TextView
    lateinit var imagen_pregunta_celula: ImageView
    lateinit var respuesta_quiz_1_tv: AppCompatButton
    lateinit var respuesta_quiz_2_tv: AppCompatButton
    lateinit var respuesta_quiz_3_tv: AppCompatButton
    lateinit var respuesta_quiz_4_tv: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_juego_celula)

        pregunta_tv = findViewById(R.id.pregunta_tv)
        imagen_pregunta_celula = findViewById(R.id.imagen_pregunta_celula)
        respuesta_quiz_1_tv = findViewById(R.id.respuesta_quiz_1_tv)
        respuesta_quiz_2_tv = findViewById(R.id.respuesta_quiz_2_tv)
        respuesta_quiz_3_tv = findViewById(R.id.respuesta_quiz_3_tv)
        respuesta_quiz_4_tv = findViewById(R.id.respuesta_quiz_4_tv)


        siguientePregunta()

        respuesta_quiz_1_tv.setOnClickListener {
            if (canAnswer) {
                respuestaActual = 1
                accionarRespuesta(respuesta_quiz_1_tv)
            }
        }
        respuesta_quiz_2_tv.setOnClickListener {
            if (canAnswer) {
                respuestaActual = 2
                accionarRespuesta(respuesta_quiz_2_tv)
            }
        }
        respuesta_quiz_3_tv.setOnClickListener {
            if (canAnswer) {
                respuestaActual = 3
                accionarRespuesta(respuesta_quiz_3_tv)
            }
        }
        respuesta_quiz_4_tv.setOnClickListener {
            if (canAnswer) {
                respuestaActual = 4
                accionarRespuesta(respuesta_quiz_4_tv)
            }
        }

    }

    fun siguientePregunta() {
        canAnswer = true
        pregunta_tv.text = preguntas[preguntaActual].pregunta
        imagen_pregunta_celula.setImageResource(preguntas[preguntaActual].img)
        respuesta_quiz_1_tv.text = preguntas[preguntaActual].respuestas[0]
        respuesta_quiz_2_tv.text = preguntas[preguntaActual].respuestas[1]
        respuesta_quiz_3_tv.text = preguntas[preguntaActual].respuestas[2]
        respuesta_quiz_4_tv.text = preguntas[preguntaActual].respuestas[3]

        respuesta_quiz_1_tv.background =
            ContextCompat.getDrawable(this@CelulaJuegoActivity, R.drawable.border_quiz_answer)
        respuesta_quiz_2_tv.background =
            ContextCompat.getDrawable(this@CelulaJuegoActivity, R.drawable.border_quiz_answer)
        respuesta_quiz_3_tv.background =
            ContextCompat.getDrawable(this@CelulaJuegoActivity, R.drawable.border_quiz_answer)
        respuesta_quiz_4_tv.background =
            ContextCompat.getDrawable(this@CelulaJuegoActivity, R.drawable.border_quiz_answer)

    }

    fun accionarRespuesta(boton: AppCompatButton) {
        if (respuestaActual == preguntas[preguntaActual].respuestaCorrecta) {
            // Respuesta correcta
            boton.setBackgroundColor(Color.GREEN)
            accionarRespuestaCorrecta()
        } else {
            boton.setBackgroundColor(Color.RED)
        }
    }

    fun accionarRespuestaCorrecta() {
        preguntaActual++

        // 6 es el max de cambios de preguntas
        if (preguntaActual > 6) {
            //TODO: finalizar
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Has terminado")
            alertDialogBuilder.setMessage("Se ha acabado el juego!")
            alertDialogBuilder.setPositiveButton("Ok") { dialog, which ->
                finish()
//                Toast.makeText(
//                    applicationContext,
//                    android.R.string.yes, Toast.LENGTH_SHORT
//                ).show()
            }.show()
        } else {

            Thread(Runnable {
                canAnswer = false
                Thread.sleep(1000)
                this@CelulaJuegoActivity.runOnUiThread(java.lang.Runnable { siguientePregunta() })

            }).start()
        }
    }


    fun intializePreguntas(): Array<CelulaPregunta> {
        //
        val opciones1 = arrayOf(
            "Unidad fundamental de la vida", "Una nuerona del sistema nervioso",
            "Un tipo de animal", "Una parte de la mitocontria"
        )

        val pregunta1 =
            CelulaPregunta(1, "Que es la celula", R.drawable.preguntas_celula, opciones1, 1)

        //
        val opciones2 = arrayOf(
            "Una mitrocontria", "Un invertebrado",
            "Una neurona", "Una particula"
        )

        val pregunta2 = CelulaPregunta(
            2,
            "¿Que es lo que se muestra en la imagen?",
            R.drawable.preguntas_neurona,
            opciones2,
            3
        )

        //
        val opciones3 = arrayOf(
            "Conjunto de plantas", "Conjunto de seres vivos, plantas y animales",
            "Conjunto de seres vivos", "Conjunto de particulas"
        )

        val pregunta3 = CelulaPregunta(
            3,
            "¿Que es un ecosistema?",
            R.drawable.preguntas_ecosistema,
            opciones3,
            2
        )

        //
        val opciones4 = arrayOf(
            "El agua", "El jugo de naranja",
            "El aceite", "El alcohol"
        )

        val pregunta4 = CelulaPregunta(
            4,
            "¿Cual es el fluido imprescindible para todos los seres vivos?",
            R.drawable.preguntas_seresvivos,
            opciones4,
            1
        )

        //
        val opciones5 = arrayOf(
            "La mitocondria", "Electron",
            "El nucleo", "Citoplasma"
        )

        val pregunta5 = CelulaPregunta(
            5,
            "¿Que parte de la celula se muestra en la imagen?",
            R.drawable.preguntas_mitocondria,
            opciones5,
            1
        )

        //
        val opciones6 = arrayOf(
            "Reptil", "Invertebrados",
            "Sangre fria", "Mamiferos"
        )

        val pregunta6 = CelulaPregunta(
            6,
            "¿Que clase del reino animal son los gatos?",
            R.drawable.preguntas_gato,
            opciones6,
            4
        )

        //
        val opciones7 = arrayOf(
            "Flor", "Hoja",
            "Raiz", "Tallo"
        )

        val pregunta7 = CelulaPregunta(
            7,
            "¿Que parte de las plantas crecen bajo tierra?",
            R.drawable.preguntas_planta,
            opciones7,
            3
        )

        //
        val opciones8 = arrayOf(
            "Invertebrado", "Vertebrado",
            "Mamifero", "Anfibio"
        )

        val pregunta8 = CelulaPregunta(
            8,
            "¿Que tipo de animal es el pulpo?",
            R.drawable.preguntas_pulpo,
            opciones8,
            1
        )
        val preguntas: Array<CelulaPregunta> =
            arrayOf(pregunta1, pregunta2, pregunta3, pregunta5, pregunta6, pregunta7, pregunta8)

//        preguntas[0] = pregunta1
//        preguntas[1] = pregunta2
//        preguntas[2] = pregunta3
//        preguntas[3] = pregunta4
//        preguntas[4] = pregunta5
//        preguntas[5] = pregunta6
//        preguntas[6] = pregunta7
//        preguntas[7] = pregunta8

        return preguntas
    }
}