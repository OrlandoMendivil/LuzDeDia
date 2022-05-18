package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class ContactosActivity : AppCompatActivity() {

    var contactos: ArrayList<Contactos> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contactos)


        llenarContactos()

        var adaptador = AdaptadorContactos(this, contactos)

        var listView: ListView = findViewById(R.id.lv2)

        listView.adapter = adaptador

        val bck: Button = findViewById(R.id.bck_button)
        bck.setOnClickListener {
            val intent: Intent = Intent(this, ParentRoomActivity::class.java)

            startActivity(intent)
        }
    }

    fun llenarContactos(){
        var contacto1 = Contactos(1,"Dra. Patricia D",R.drawable.imagen_avatar)
        contactos.add(contacto1)
    }
}