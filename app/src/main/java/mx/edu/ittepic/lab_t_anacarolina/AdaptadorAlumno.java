package mx.edu.ittepic.lab_t_anacarolina;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Carolina Mondragon on 12/02/2018.
 */

public class AdaptadorAlumno  extends RecyclerView.Adapter<AdaptadorAlumno.ViewHolderAlumnos> implements View.OnClickListener,View.OnCreateContextMenuListener {
    ArrayList<alumno> listaAlumnos;
    private View.OnClickListener listener;
    Context context;
    public AdaptadorAlumno(ArrayList<alumno> listaAlumnos,Context context) {
        this.listaAlumnos = listaAlumnos;
        this.context=context;
    }

    @Override
    public ViewHolderAlumnos onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=R.layout.alumno_vista;
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);
        view.setOnClickListener(this);
        view.setOnCreateContextMenuListener(this);
        return new ViewHolderAlumnos(view);
    }
    @Override
    public void onBindViewHolder(ViewHolderAlumnos holder, int position) {

        holder.nombre_alumno.setText(listaAlumnos.get(position).getNombre_alumno());
        holder.carrera_alumno.setText(listaAlumnos.get(position).getCarrera());
        holder.numero_control.setText(""+listaAlumnos.get(position).getIdalumno());
        int imageResource = context.getResources().getIdentifier(listaAlumnos.get(position).getFoto(), null, context.getPackageName());
        holder.foto.setImageDrawable(context.getResources().getDrawable(imageResource));

    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }


    public void onCreateContextMenu(ContextMenu menu, View v,      ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem Editar = menu.add(Menu.NONE, 1, 1, "EDITAR");
        MenuItem Borrar = menu.add(Menu.NONE, 2, 2, "ELIMINAR");
        Editar.setOnMenuItemClickListener(onEditMenu);
        Borrar.setOnMenuItemClickListener(onEditMenu);


    }

    private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {


            switch (item.getItemId()) {
                case 1:
                    
                    break;
                case 2:

                    break;
            }
            return true;
        }
    };



    public class ViewHolderAlumnos extends RecyclerView.ViewHolder {

        TextView nombre_alumno,carrera_alumno,numero_control;
        ImageView foto;

        public ViewHolderAlumnos(View itemView) {
            super(itemView);
            nombre_alumno= (TextView) itemView.findViewById(R.id.nombre_alumno);
            carrera_alumno= (TextView) itemView.findViewById(R.id.carrera);
            numero_control= (TextView) itemView.findViewById(R.id.numero_control);
            foto= (ImageView) itemView.findViewById(R.id.imagen);
        }
    }
}
