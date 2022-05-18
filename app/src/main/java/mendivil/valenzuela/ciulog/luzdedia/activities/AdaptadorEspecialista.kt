package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import mendivil.valenzuela.ciulog.luzdedia.R

class AdaptadorEspecialista: BaseAdapter{

    lateinit var context: Context
    var especialistas : ArrayList<Especialistas>

   constructor(context: Context, especialistas: ArrayList<Especialistas>){
       this.context=context
       this.especialistas = especialistas
   }

    override fun getCount(): Int {
        return especialistas.size
    }

    override fun getItem(p0: Int): Any {
    return especialistas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.especialista_datos, null)
        var img : ImageView = vista.findViewById(R.id.img1)
        var nombre : TextView = vista.findViewById(R.id.tv_nombre1)

        var especialista: Especialistas = especialistas[p0]

        img.setImageResource(especialista.img)
        nombre.setText(especialista.nombre)
        return vista
    }

}