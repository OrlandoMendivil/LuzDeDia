package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class MenuPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_juegos)

        val palabras_llanas_iv : ImageView = findViewById(R.id.palabras_llanas_iv)
        palabras_llanas_iv.setOnClickListener{
            val intent: Intent = Intent(this, PalabrasLlanasJuegoActivity::class.java)

            startActivity(intent)
        }
    }
}