import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.*;

public class InscripcionTest {
    private Alumno gabriel;
    private Alumno martin;
    private Alumno jose;
    private Materia paradigmas;
    private Materia gestion;
    private Materia disenio;
    private Materia economia;
    private Inscripcion inscripcion;


    @Before
    public void setUp() {
        gabriel = new Alumno("Gabriel", "Acevedo");
        martin = new Alumno("Martin", "Nose");
        jose = new Alumno("Jose", "Nose");

        Set<Materia> materias = new HashSet<>();
        paradigmas = new Materia("Paradigmas", materias);
        gestion = new Materia("Gestion", materias);

        final Set<Materia> correlativasDisenio = new HashSet<>();
        final Set<Materia> correlativasEconomia = new HashSet<>();

        correlativasDisenio.add(paradigmas);
        correlativasDisenio.add(gestion);

        correlativasEconomia.add(gestion);

        disenio = new Materia("DDS", correlativasDisenio);
        economia = new Materia("Eco",  correlativasEconomia);

        gabriel.agregarMateriaAprobada(paradigmas);
        gabriel.agregarMateriaAprobada(gestion);
        martin.agregarMateriaAprobada(paradigmas);

    }

    @Test
    public void inscripcionAprobada1Materia() {
        Set<Materia> materiasACursar = new HashSet<>();
        materiasACursar.add(disenio);
        inscripcion = new Inscripcion(materiasACursar, gabriel);
        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void inscripcionDesaprobada1Materia() {
        Set<Materia> materiasACursar = new HashSet<>();
        materiasACursar.add(disenio);
        inscripcion = new Inscripcion(materiasACursar, martin);
        Assertions.assertFalse(inscripcion.aprobada());
    }

    @Test
    public void inscripcionAprobadaVariasMaterias() {
        Set<Materia> materiasACursar = new HashSet<>();
        materiasACursar.add(disenio);
        materiasACursar.add(economia);
        inscripcion = new Inscripcion(materiasACursar, gabriel);
        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void inscripcionDesaprobadaVariasMaterias() {
        Set<Materia> materiasACursar = new HashSet<>();
        materiasACursar.add(disenio);
        materiasACursar.add(economia);
        inscripcion = new Inscripcion(materiasACursar, martin);
        Assertions.assertFalse(inscripcion.aprobada());
    }

    @Test
    public void inscripcionAprobadaSinCorrelativas() {
        Set<Materia> materiasACursar = new HashSet<>();
        materiasACursar.add(paradigmas);
        inscripcion = new Inscripcion(materiasACursar, jose);
        Assertions.assertTrue(inscripcion.aprobada());
    }
}


