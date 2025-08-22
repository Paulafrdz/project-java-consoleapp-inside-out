package dev.paula.movie.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dev.paula.movie.models.Movie;

public class MovieCSVRepository {

    private static final String CSV_FILE = "movies.csv";

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
                writer.append(movie.getDatePublished());
                writer.append(",");
                writer.append(movie.getCreationDate());
                writer.append("\n");
            }
            System.out.println("Archivo CSV generado exitosamente en: " + filePath);

        }catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }

    public void save(Movie movie) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            writer.println(movie.toCSVString());
            System.out.println("Movie saved successfully: " + movie.getName());
        } catch (IOException e) {
            System.err.println("Error saving movie to CSV: " + e.getMessage());
        }
    }
}
