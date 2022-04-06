package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class ParentRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parents_room)

        val imgBtnForo: ImageButton = findViewById(R.id.imgBtnForo)
        imgBtnForo.setOnClickListener {
            val intent: Intent = Intent(this, ForoActivity::class.java)

            startActivity(intent)
        }

        val imgBtnContactos: ImageButton = findViewById(R.id.imgBtnContactos)
        imgBtnContactos.setOnClickListener {
            val intent: Intent = Intent(this, ContactosActivity::class.java)

            startActivity(intent)
        }

        val imgBtnEspecialistas: ImageButton = findViewById(R.id.imgBtnEspecialistas)
        imgBtnEspecialistas.setOnClickListener {
            val intent: Intent = Intent(this, ListaEspecialistasActivity::class.java)

            startActivity(intent)
        }

        val imgBtnCalendario: ImageButton = findViewById(R.id.imgBtnCalendario)
        imgBtnCalendario.setOnClickListener {
            val intent: Intent = Intent(this, CalendarioActivity::class.java)

            startActivity(intent)
        }
    }
}