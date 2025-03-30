
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    String nombre;
    @Getter
    Set<Materia> correlativas;

    public Materia(String nombre, Set<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public Boolean cumpleCorrelativas(Set<Materia> materias) {
        return materias.containsAll(correlativas);
    }
}
