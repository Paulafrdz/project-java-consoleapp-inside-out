package dev.paula.movie.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import dev.paula.movie.models.Movie;

public class MovieCSVRepository {

    public static void exportMovieCSV(List<Movie> movies, String filePath) {

    try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Título,Género/s,Emoción,Estreno,Creación\n");

        for(Movie movie : movies) {
                writer.append(movie.getName());
                writer.append(",");
                String genres = String.join("|", movie.getGenre());
                writer.append(genres);
                writer.append(",");
                writer.append(movie.getEmotion().name());
                writer.append(",");
                writer.append(movie.getReleaseYear());
                writer.append(",");
                writer.append(movie.getCreatedAt());
                writer.append("\n");
            }
            System.out.println("Archivo CSV generado exitosamente en: " + filePath);

        }catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
