package dominio.inscripciones;

import dominio.materias.Materia;
import dominio.personas.Alumno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private List<Materia> materiasSolicitadas;
    private Alumno alumnoSolicitante;

    public Inscripcion(Alumno alumnoSolicitante) {
        this.alumnoSolicitante = alumnoSolicitante;
        this.materiasSolicitadas = new ArrayList<Materia>();
    }

    public boolean aprobada() {
        return this.materiasSolicitadas
                .stream()
                .allMatch(materia -> materia.puedeCursarla(this.alumnoSolicitante));
    }

    public void agregarMateriaSolicitada(Materia ... materia) {
        Collections.addAll(this.materiasSolicitadas, materia);
    }
}
