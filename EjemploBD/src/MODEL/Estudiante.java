package MODEL;

public class Estudiante {
    public String nombre;
    public String cedula;
    public String correo;
    public int notaFinal;
    public String estado;

    public Estudiante(String nombre, String cedula, String correo, int notaFinal) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.notaFinal = notaFinal;
    }

    public Estudiante(String nombre, String cedula, String correo, int notaFinal, String estado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.notaFinal = notaFinal;
        this.estado = estado;
    }

    public void establecerEstado(){
        if (notaFinal>=7){
            estado="Aprobado";
        }else {
            estado="Reprobado";
        }
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", notaFinal=" + notaFinal +
                ", estado='" + estado + '\'' +
                '}';
    }
}
