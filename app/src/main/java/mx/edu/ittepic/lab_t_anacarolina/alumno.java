package mx.edu.ittepic.lab_t_anacarolina;

/**
 * Created by Carolina Mondragon on 12/02/2018.
 */

public class alumno {
    int idalumno;
    String nombre_alumno;
    String foto;
    String carrera;

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public alumno(int idalumno, String nombre_alumno, String foto, String carrera) {

        this.idalumno = idalumno;
        this.nombre_alumno = nombre_alumno;
        this.foto = foto;
        this.carrera = carrera;
    }
}
