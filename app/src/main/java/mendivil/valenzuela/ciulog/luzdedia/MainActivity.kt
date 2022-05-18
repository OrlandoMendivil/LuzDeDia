package mendivil.valenzuela.ciulog.luzdedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import mendivil.valenzuela.ciulog.luzdedia.activities.CelulaJuegoActivity
import mendivil.valenzuela.ciulog.luzdedia.activities.LoginActivity
import mendivil.valenzuela.ciulog.luzdedia.activities.MenuActivity
import mendivil.valenzuela.ciulog.luzdedia.activities.PalabrasLlanasJuegoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startup_screen)

        val palabras_llanas_iv : ImageView = findViewById(R.id.logo_startup_iv)
        palabras_llanas_iv.setOnClickListener{
            val intent: Intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }
    }
}