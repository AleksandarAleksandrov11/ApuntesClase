package gson;

public class Miembro {
    private String nombre;
    private int edad;
    private String rol;
    private boolean activo;

    // Constructor
    public Miembro(String nombre, int edad, String rol, boolean activo) {
        this.nombre = nombre;
        this.edad = edad;
        this.rol = rol;
        this.activo = activo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
