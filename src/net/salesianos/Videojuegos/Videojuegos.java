package net.salesianos.Videojuegos;

public class Videojuegos {
    private String titulo;
    private String genero;
    private int horasJugadas;

    public Videojuegos(String titulo, String genero, int horasJugadas) {
        this.titulo = titulo;
        this.genero = genero;
        this.horasJugadas = horasJugadas;
    }

    public String getTitulo() { return titulo; }
    public int getHorasJugadas() { return horasJugadas; }

    @Override
    public String toString() {
        return titulo + " - " + genero + " - " + horasJugadas;
    }

}