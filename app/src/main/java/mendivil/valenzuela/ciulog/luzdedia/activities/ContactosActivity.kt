package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class ContactosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contactos)

        val bck: Button = findViewById(R.id.bck_button)
        bck.setOnClickListener {
            val intent: Intent = Intent(this, ParentRoomActivity::class.java)

            startActivity(intent)
        }
    }
}