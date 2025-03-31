package dominio.personas;

import dominio.materias.Materia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private Integer legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, Integer legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<Materia>();
    }

    public boolean aprobo(Materia materia) {
        return this.materiasAprobadas.contains(materia);
    }

    public void agregarMateriaAprobada(Materia ... materia) {
        Collections.addAll(this.materiasAprobadas, materia);
    }
}
