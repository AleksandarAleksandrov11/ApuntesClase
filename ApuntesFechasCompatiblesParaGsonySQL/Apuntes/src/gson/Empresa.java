package gson;

import java.util.List;

public class Empresa {
    private String nombre;
    private int fundado;
    private List<Miembro> equipo;
    private Boolean isStartup;
    private Double presupuesto; // Puede ser nulo

    // Constructor
    public Empresa(String nombre, int fundado, List<Miembro> equipo, Boolean isStartup, Double presupuesto) {
        this.nombre = nombre;
        this.fundado = fundado;
        this.equipo = equipo;
        this.isStartup = isStartup;
        this.presupuesto = presupuesto;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFundado() {
        return fundado;
    }

    public void setFundado(int fundado) {
        this.fundado = fundado;
    }

    public List<Miembro> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Miembro> equipo) {
        this.equipo = equipo;
    }

    public Boolean getIsStartup() {
        return isStartup;
    }

    public void setIsStartup(Boolean isStartup) {
        this.isStartup = isStartup;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
