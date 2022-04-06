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

        val palabras_llanas : ImageView = findViewById(R.id.palabras_llanas_iv)
        palabras_llanas.setOnClickListener{
            val intent: Intent = Intent(this, PalabrasLlanasJuegoActivity::class.java)

            startActivity(intent)
        }

        val celula : ImageView = findViewById(R.id.celula_logo_iv)
        celula.setOnClickListener{
            val intent: Intent = Intent(this, CelulaJuegoActivity::class.java)

            startActivity(intent)
        }
    }
}