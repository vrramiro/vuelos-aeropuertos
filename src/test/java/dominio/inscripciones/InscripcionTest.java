package dominio.inscripciones;

import dominio.materias.Materia;
import dominio.personas.Alumno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("Un alumno con todas las correlativas de sus materias deseadas, tiene su inscripcion aprobada")
    public void InscripcionAprobadaPorCorrelativas() {
        Alumno juan = new Alumno("Juan","Riquelme", 2045778);
        Materia analisis2 = new Materia("Analisis II");
        Materia analisis1 = new Materia("Analisis I");
        Materia paradigmas = new Materia("Paradigmas");
        Materia algoritmos = new Materia("Algoritmos");
        Materia algebra = new Materia("Algebra");
        Inscripcion inscripcionJuan = new Inscripcion(juan);

        juan.agregarMateriaAprobada(analisis1, algebra, algoritmos);
        analisis2.agregarCorrelativa(analisis1, algebra);
        paradigmas.agregarCorrelativa(algoritmos);
        inscripcionJuan.agregarMateriaSolicitada(analisis2, paradigmas);

        Assertions.assertTrue(inscripcionJuan.aprobada());
    }

    @Test
    @DisplayName("Un alumno al que le faltan correlativas de sus materias deseadas, no tiene su inscripcion aprobada")
    public void InscripcionDesaprobadaPorCorrelativas() {
        Alumno juan = new Alumno("Juan","Riquelme", 2045778);
        Materia analisis2 = new Materia("Analisis II");
        Materia analisis1 = new Materia("Analisis I");
        Materia paradigmas = new Materia("Paradigmas");
        Materia algoritmos = new Materia("Algoritmos");
        Materia algebra = new Materia("Algebra");
        Materia discreta = new Materia("Discreta");
        Materia sintaxis = new Materia("Sintaxis");
        Inscripcion inscripcionJuan = new Inscripcion(juan);

        juan.agregarMateriaAprobada(analisis1, algebra, algoritmos);
        analisis2.agregarCorrelativa(analisis1, algebra);
        paradigmas.agregarCorrelativa(algoritmos);
        sintaxis.agregarCorrelativa(algoritmos, discreta);
        inscripcionJuan.agregarMateriaSolicitada(analisis2, paradigmas, sintaxis);

        Assertions.assertFalse(inscripcionJuan.aprobada());
    }
}