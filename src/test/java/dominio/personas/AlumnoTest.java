package dominio.personas;

import dominio.materias.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    @Test
    @DisplayName("Un alumno tiene una materia aprobada")
    public void TieneMateriaAprobada() {
        Alumno juan = new Alumno("Juan","Riquelme", 2045778);
        Materia analisis2 = new Materia("Analisis II");

        juan.agregarMateriaAprobada(analisis2);

        Assertions.assertTrue(juan.aprobo(analisis2));
    }

    @Test
    @DisplayName("Un alumno no tiene una materia aprobada")
    public void NoTieneMateriaAprobada() {
        Alumno juan = new Alumno("Juan","Riquelme", 2045778);
        Materia analisis2 = new Materia("Analisis II");
        Materia analisis1 = new Materia("Analisis I");

        juan.agregarMateriaAprobada(analisis1);

        Assertions.assertFalse(juan.aprobo(analisis2));
    }
}