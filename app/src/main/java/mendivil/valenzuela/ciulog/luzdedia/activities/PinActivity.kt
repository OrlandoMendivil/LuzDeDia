package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class PinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pin)

        val kids_zone : ImageView = findViewById(R.id.kids_zone_imb)
        kids_zone.setOnClickListener{
            val intent: Intent = Intent(this, PantallaJuegoActivity::class.java)

            startActivity(intent)
        }

        val btn_comenzar : Button = findViewById(R.id.btn_comenzar)
        btn_comenzar.setOnClickListener{
            val intent: Intent = Intent(this, ParentRoomActivity::class.java)

            startActivity(intent)
        }
    }
}