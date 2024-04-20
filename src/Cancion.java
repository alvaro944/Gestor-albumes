public class Cancion {
    private String titulo;
    private double duracion;

    public Cancion(String titulo, double duracion){
        this.titulo = titulo;
        this.duracion =duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", duración: " + duracion;
    }
}
