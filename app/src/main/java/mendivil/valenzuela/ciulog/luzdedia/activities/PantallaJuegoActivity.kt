package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class PantallaJuegoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_juegos)

        //Se cambio el juego de palabras llanas a juego de memoria.
        val memorama : ImageView = findViewById(R.id.memorama_iv)
        memorama.setOnClickListener{
            val intent: Intent = Intent(this, Memory_game::class.java)

            startActivity(intent)
        }

        val celula : ImageView = findViewById(R.id.celula_logo_iv)
        celula.setOnClickListener{
            val intent: Intent = Intent(this, CelulaJuegoActivity::class.java)

            startActivity(intent)
        }
    }
}