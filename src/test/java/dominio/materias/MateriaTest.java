package dominio.materias;

import dominio.personas.Alumno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MateriaTest {

    @Test
    @DisplayName("Un alumno con todas las correlativas de una materia, aprobadas, puede cursarla")
    public void PuedeCursarla() {
        Materia analisis2 = new Materia("Analisis II");
        Materia analisis1 = new Materia("Analisis I");
        Alumno juan = new Alumno("Juan","Riquelme",2042556);

        juan.agregarMateriaAprobada(analisis1);
        analisis2.agregarCorrelativa(analisis1);

        Assertions.assertTrue(analisis2.puedeCursarla(juan));
    }

    @Test
    @DisplayName("Un alumno con no puede cursar una materia porque le faltan correlativas")
    public void NoPuedeCursarla() {
        Materia analisis2 = new Materia("Analisis II");
        Materia paradigmas = new Materia("Paradigmas");
        Materia analisis1 = new Materia("Analisis I");
        Materia algebra = new Materia("Algebra");
        Alumno juan = new Alumno("Juan","Riquelme",2042556);

        juan.agregarMateriaAprobada(paradigmas, algebra);

        analisis2.agregarCorrelativa(analisis1, algebra);

        Assertions.assertFalse(analisis2.puedeCursarla(juan));
    }
}