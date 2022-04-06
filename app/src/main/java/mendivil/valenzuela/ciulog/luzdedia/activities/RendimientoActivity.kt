package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class RendimientoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_rendimiento)

        val calendario_btn: Button = findViewById(R.id.calendario_btn)
        calendario_btn.setOnClickListener {
            val intent: Intent = Intent(this, CalendarioActivity::class.java)

            startActivity(intent)
        }

        val perfil_btn: Button = findViewById(R.id.perfil_btn)
        perfil_btn.setOnClickListener {
            val intent: Intent = Intent(this, ParentRoomActivity::class.java)

            startActivity(intent)
        }

        val notas_btn: Button = findViewById(R.id.notas_btn)
        notas_btn.setOnClickListener {
            val intent: Intent = Intent(this, Notas2Activity::class.java)

            startActivity(intent)
        }
    }
}