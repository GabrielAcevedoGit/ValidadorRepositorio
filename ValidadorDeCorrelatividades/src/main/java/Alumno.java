import lombok.Getter;
import java.util.HashSet;
import java.util.Set;

public class Alumno {
    String nombre;
    String apellido;

    @Getter
    Set<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = new HashSet<Materia>();
    }

    public void agregarMateriaAprobada(Materia materia){
        materiasAprobadas.add(materia);
    }

}
