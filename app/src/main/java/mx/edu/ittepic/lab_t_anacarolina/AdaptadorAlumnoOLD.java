package mx.edu.ittepic.lab_t_anacarolina;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Carolina Mondragon on 12/02/2018.
 */

public class AdaptadorAlumnoOLD extends BaseAdapter {
    private Activity actividad;
    private ArrayList<alumno> elementos;
    alumno elemento;
    View vista;
    ViewGroup parent2;
    ImageView foto;
    private botonClick btnMasinfo = null;
    public AdaptadorAlumnoOLD(Activity actividad, ArrayList<alumno> elementos, botonClick btnMasinfo) {
        this.actividad = actividad;
        this.elementos = elementos;
        this.btnMasinfo=btnMasinfo;

    }
    public interface botonClick {
        public abstract void onBtnClick(int position);
    }
    @Override
    public int getCount() {
        return elementos.size();
    }
    @Override
    public Object getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return elementos.get(position).getIdalumno();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        vista = convertView;

        if (vista == null) {
            LayoutInflater inflater = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.alumno_vista, null);
        }
        elemento = elementos.get(position);


         parent2=parent;
        TextView nombre = (TextView) vista.findViewById(R.id.nombre_alumno);
        nombre.setText(elemento.getNombre_alumno());
        TextView nombre_carrera = (TextView) vista.findViewById(R.id.carrera);
        nombre_carrera.setText(elemento.getCarrera());
        TextView numero_control = (TextView) vista.findViewById(R.id.numero_control);
        numero_control.setText(""+elemento.getIdalumno());

        ImageView image = (ImageView) vista.findViewById(R.id.imagen);
        int imageResource = actividad.getResources().getIdentifier(elemento.getFoto(), null, actividad.getPackageName());
        image.setImageDrawable(actividad.getResources().getDrawable(imageResource));


        return vista;
    }
}
