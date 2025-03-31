package dominio.materias;

import dominio.personas.Alumno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<Materia>();
    }

    public boolean puedeCursarla(Alumno alumnoSolicitante) {
        return this.correlativas.stream().allMatch(materia -> alumnoSolicitante.aprobo(materia));
    }

    public void agregarCorrelativa(Materia ... materia) {
        Collections.addAll(this.correlativas, materia);
    }
}
