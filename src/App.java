import java.nio.file.*;
import java.util.*;
import net.salesianos.Videojuegos.Videojuegos;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> lineas = Files.readAllLines(Path.of("videojuegos.csv"));

        List<Videojuegos> lista = new ArrayList<>();

        for (int i = 1; i < lineas.size(); i++) {
            String[] partes = lineas.get(i).split(",");

            String titulo = partes[0];
            String genero = partes[1];
            int horas = Integer.parseInt(partes[2].trim());

            lista.add(new Videojuegos(titulo, genero, horas));
        }

        int total = lista.size();

        int suma = 0;
        Videojuegos max = lista.get(0);

        for (Videojuegos v : lista) {
            suma += v.getHorasJugadas();
            if (v.getHorasJugadas() > max.getHorasJugadas()) {
                max = v;
            }
        }

        double media = (double) suma / total;

        String resumen = "Total: " + total + "\n"
                + "Horas: " + suma + "\n"
                + "Media: " + media + "\n"
                + "Max: " + max;

        Files.writeString(Path.of("resumen_videojuegos.txt"), resumen);

        Files.writeString(
                Path.of("log_videojuegos.txt"),
                "Programa ejecutado\n",
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}