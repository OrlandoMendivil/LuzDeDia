package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import mendivil.valenzuela.ciulog.luzdedia.R

class AdaptadorContactos: BaseAdapter {

    lateinit var context: Context
    var contactos: ArrayList<Contactos>

    constructor(context: Context, contactos: ArrayList<Contactos>){
        this.context = context
        this.contactos =contactos
    }

    override fun getCount(): Int {
        return contactos.size
    }

    override fun getItem(p0: Int): Any {
        return contactos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.contacto_datos, null)
        var img : ImageView = vista.findViewById(R.id.img2)
        var nombre : TextView = vista.findViewById(R.id.nombre2)

        var contactos: Contactos = contactos[p0]

        img.setImageResource(contactos.img)
        nombre.setText(contactos.nombre)
        return vista
    }


}