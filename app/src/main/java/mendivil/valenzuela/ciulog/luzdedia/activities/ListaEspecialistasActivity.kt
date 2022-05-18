package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class ListaEspecialistasActivity : AppCompatActivity() {
    var especialistas : ArrayList<Especialistas> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_especialistas)

        llenarEspecialistas()

        var adaptador = AdaptadorEspecialista(this, especialistas)

        var listView: ListView = findViewById(R.id.lv1)

        listView.adapter = adaptador

        val back: Button = findViewById(R.id.btn_back)
        back.setOnClickListener {
            val intent: Intent = Intent(this, ParentRoomActivity::class.java)
            startActivity(intent)
        }



    }

    fun llenarEspecialistas(){
        val especialista1 = Especialistas(1, "Dra. Patricia D.", R.drawable.imagen_avatar)
        especialistas.add(especialista1)
    }


}