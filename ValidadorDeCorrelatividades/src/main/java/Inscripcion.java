
import java.time.LocalDateTime;
import java.util.Set;

public class Inscripcion {

    Set<Materia> materiasACursar;
    Boolean fueAprobada = false;
    Alumno alumno;
    LocalDateTime fechaDeEvaluacion;

    public Inscripcion(Set<Materia> materiasACursar, Alumno alumno) {
        this.materiasACursar = materiasACursar;
        this.alumno = alumno;
    }

    public boolean aprobada(){
        fechaDeEvaluacion = LocalDateTime.now();
        for (Materia materia : materiasACursar) {
            if(!materia.cumpleCorrelativas(alumno.getMateriasAprobadas())){
                this.fueAprobada = false;
                return false;
            }
        }
        this.fueAprobada = true;
        return true;
    }
}
