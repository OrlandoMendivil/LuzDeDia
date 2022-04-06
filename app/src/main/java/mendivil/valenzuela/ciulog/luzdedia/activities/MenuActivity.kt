package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val kids_zone : ImageView = findViewById(R.id.kids_zone_imb)
        kids_zone.setOnClickListener{
            val intent: Intent = Intent(this, PantallaJuegoActivity::class.java)

            startActivity(intent)
        }

        val sala_padres : ImageView = findViewById(R.id.sala_padres_imb)
        sala_padres.setOnClickListener{
            val intent: Intent = Intent(this, PinActivity::class.java)

            startActivity(intent)
        }
    }
}