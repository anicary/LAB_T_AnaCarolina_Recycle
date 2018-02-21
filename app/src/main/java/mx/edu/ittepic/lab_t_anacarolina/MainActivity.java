package mx.edu.ittepic.lab_t_anacarolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<alumno> listaAlumnos;
    RecyclerView listaObjetos;
    private RecyclerView.LayoutManager mLayoutManager;
    AdaptadorAlumno adapter;

    String [] nombres={"ARANDA PATRON NOMAR JAZIEL",
            "CARDENAS RAMOS FRANCISCO EMANUEL",
            "CASTILLO CORRALES VICTOR EMMANUEL",
            "CERVANTES JIMÉNEZ JOSÉ MIGUEL",
            "CORDERO RIVERA SELVA YAZMIN",
            "CORDERO VILLA OSCAR ALBERTO",
            "ESPINOSA ABANDO DENISSE YANETH",
            "FIGUEROA CUETO JUAN RAMON",
            "GALLEGOS GODINEZ FRANCISCO JAVIER",
            "GIL LLANOS JUAN PEDRO",
            "GONZALEZ ARELLANO ERNESTO",
            "GUTIERREZ ESPARZA BRAYAN JESUS",
            "GUTIÉRREZ ROJAS BRYAN",
            "LOPEZ ALVARADO MISSAEL",
            "MARTINEZ BAÑUELOS ERIKA LIZBETH",
            "MENDEZ SANTANA KEVIN ALEJANDRO",
            "MONROY SALCEDO JOSE DE JESUS",
            "PADILLA SIMÓN BRIAN EFRÉN",
            "PARRA DOMINGUEZ DYLAN SALVADOR",
            "PEREZ ARAIZA FLOR MARIELA",
            "PUGA FLORES CARLOS",
            "REYES GODINEZ CARLA GUADALUPE",
            "REYES GUERRERO GUILLERMO GUADALUPE",
            "RICO ESPARZA HENRY",
            "RIVERA RAMIREZ DAVID",
            "SANCHEZ CARRILLO BETSY DEL CARMEN",
            "SILVA CAMACHO EDUARDO LUIS",
            "TORRES CUETO JESUS MANUEL",
            "VALDEZ LOPEZ HOLLIVER EDUARDO",
            "VALENZUELA MIRAMONTES JOSE PABLO",
            "ZAMORANO ALCALÁ GUILLERMO"};



@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaObjetos = (RecyclerView) findViewById(R.id.caru);
        listaObjetos.setLayoutManager(new LinearLayoutManager(this));
        listaAlumnos=new ArrayList<>();
        obtenerAlumnos();

        adapter=new AdaptadorAlumno(listaAlumnos,getApplicationContext());
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        listaObjetos.setAdapter(adapter);

    }
    public void obtenerAlumnos(){
        for (int i=0;i< nombres.length;i++ ) {
            listaAlumnos.add(new alumno(14401038,nombres[i],"@drawable/p","TICS"));
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_alumno, menu);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        long itemID = info.position;
        menu.setHeaderTitle("lior" + itemID);
    }


}
