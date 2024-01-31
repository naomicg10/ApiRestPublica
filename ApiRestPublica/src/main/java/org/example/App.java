package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws Exception {

        // Cuantas series de "Dragon Ball" hay registradas.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/idbyTitle/Dragon%20Ball/"))
                .header("X-RapidAPI-Key", "3f7751a7edmshca9828f9525e3b6p1593a2jsn362f90fcc1f4")
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.body());

            // Obtén la lista de series
            JsonNode seriesList = jsonNode.get("results");

            // Imprime el número total de series
            int numberOfSeries = seriesList.size();
            System.out.println("Número de series de Dragon Ball registradas: " + numberOfSeries + "\n");

        } else {
            System.out.println("Error en la solicitud. Código de estado: " + response.statusCode());
        }

        // La url del poster de la primera serie que aparece registrada (del 1995)
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/id/tt0280249/"))
                .header("X-RapidAPI-Key", "3f7751a7edmshca9828f9525e3b6p1593a2jsn362f90fcc1f4")
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response1 = HttpClient.newHttpClient().send(request1, HttpResponse.BodyHandlers.ofString());
        if (response1.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response1.body());

            // Obtén la lista de series
            JsonNode seriesList = jsonNode.get("results");

            // Verifica si hay al menos una serie
            if (seriesList.size() > 0) {
                // Obtiene la URL del póster de la primera serie
                String posterUrl = seriesList.get("image_url").asText();
                System.out.println("URL del póster de la primera serie: " + posterUrl + "\n");
            } else {
                System.out.println("No hay series registradas.");
            }
        } else {
            System.out.println("Error en la solicitud. Código de estado: " + response1.statusCode());
        }

        // El título y argumento del primer episodio de la 3ª saga (temporada) de la serie: Saga del Ejército de la Patrulla Roja.
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/id/tt0280249/season/3/episode/1/"))
                .header("X-RapidAPI-Key", "3f7751a7edmshca9828f9525e3b6p1593a2jsn362f90fcc1f4")
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
        if (response2.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response2.body());

            // Obtén la lista de series
            JsonNode seriesList = jsonNode.get("results");

            if (seriesList.size() > 0) {
                String title = seriesList.get("title").asText();
                String description = seriesList.get("description").asText();

                System.out.println("Título del primer episodio: " + title);
                System.out.println("Argumento del primer episodio: " + description + "\n");
            } else {
                System.out.println("No hay episodios registrados para la saga y temporada especificadas.");
            }
        } else {
            System.out.println("Error en la solicitud. Código de estado: " + response2.statusCode());
        }

        // Lugar de nacimiento y el signo del zodiaco del actor que hacía de Goku en la pelicula “Dragonball Evolution”
        HttpRequest request3 = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/actor/id/nm0154226/"))
                .header("X-RapidAPI-Key", "3f7751a7edmshca9828f9525e3b6p1593a2jsn362f90fcc1f4")
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response3 = HttpClient.newHttpClient().send(request3, HttpResponse.BodyHandlers.ofString());
        if (response3.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response3.body());

            // Obtén la lista de series
            JsonNode seriesList = jsonNode.get("results");

            if (seriesList.size() > 0) {
                String birthPlace = seriesList.get("birth_place").asText();
                String starSign = seriesList.get("star_sign").asText();

                System.out.println("Lugar de nacimiento: " + birthPlace);
                System.out.println("Signo del zodiaco: " + starSign + "\n");
            } else {
                System.out.println("No hay episodios registrados para la saga y temporada especificadas.");
            }
        } else {
            System.out.println("Error en la solicitud. Código de estado: " + response3.statusCode());
        }

        // Del año en que nació el anterior actor, ¿cuántas películas hay registradas en la base de datos?
        HttpRequest request4 = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/movie/byYear/1982/"))
                .header("X-RapidAPI-Key", "3f7751a7edmshca9828f9525e3b6p1593a2jsn362f90fcc1f4")
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response4 = HttpClient.newHttpClient().send(request4, HttpResponse.BodyHandlers.ofString());
        if (response4.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response4.body());

            // Obtén la lista de series
            JsonNode seriesList = jsonNode.get("results");

            int numberOfMovies = seriesList.size();
            System.out.println("Número de peliculas registradas: " + numberOfMovies + "\n");

        } else {
            System.out.println("Error en la solicitud. Código de estado: " + response4.statusCode());
        }

        // De ese mismo año es la película Postergeist, el primer gran éxito de Steven Spielberg como productor,
        // que participó en los premios Oscars al año siguiente sin ser ganadora. ¿A qué apartado fue nominada?
        // ¿Que otro premio ganó ese año?
        HttpRequest request5 = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/movie/id/tt0084516/awards/"))
                .header("X-RapidAPI-Key", "3f7751a7edmshca9828f9525e3b6p1593a2jsn362f90fcc1f4")
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response5 = HttpClient.newHttpClient().send(request5, HttpResponse.BodyHandlers.ofString());
        if (response5.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response5.body());

            JsonNode awardsNode = jsonNode.get("results");

            if (awardsNode.isArray() && awardsNode.size() > 0) {
                JsonNode firstAward = awardsNode.get(0);
                String type = firstAward.get("type").asText();
                String awardName = firstAward.get("award_name").asText();
                String awardCategory = firstAward.get("award").asText();

                // Imprime los detalles de la nominación o el premio
                System.out.println("Tipo: " + type);
                System.out.println("Nombre del premio: " + awardName);
                System.out.println("Categoría del premio: " + awardCategory);
            } else {
                System.out.println("No se encontraron premios.");
            }

        }else{
                System.out.println("Error en la solicitud. Código de estado: " + response5.statusCode());
        }

    }
}
