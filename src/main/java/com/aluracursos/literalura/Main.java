package com.aluracursos.literalura;

import com.aluracursos.literalura.model.Author;
import com.aluracursos.literalura.model.Book;
import com.aluracursos.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Main implements CommandLineRunner {

    private final BookService bookService;

    @Autowired
    public Main(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Buscar libros por autor");
            System.out.println("3. Buscar libros por idioma");
            System.out.println("4. Listar todos los libros");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            // Validar la entrada de la opción
            while (!scanner.hasNextInt()) {
                System.out.println("Opción inválida. Ingrese un número entre 1 y 5.");
                scanner.next(); // Limpiar el buffer
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer después de leer la opción

            switch (opcion) {
                case 1:
                    // Buscar libro por título
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    if (titulo.isEmpty()) {
                        System.out.println("El título no puede estar vacío.");
                    } else {
                        List<Book> libros = bookService.searchBooksByTitle(titulo);
                        mostrarResultados(libros);
                    }
                    break;

                case 2:
                    // Buscar libros por autor
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    if (autor.isEmpty()) {
                        System.out.println("El autor no puede estar vacío.");
                    } else {
                        List<Book> librosPorAutor = bookService.searchBooksByAuthor(autor);
                        mostrarResultados(librosPorAutor);
                    }
                    break;

                case 3:
                    // Buscar libros por idioma
                    System.out.print("Ingrese el idioma: ");
                    String idioma = scanner.nextLine();
                    if (idioma.isEmpty()) {
                        System.out.println("El idioma no puede estar vacío.");
                    } else {
                        List<Book> librosPorIdioma = bookService.searchBooksByLanguage(idioma);
                        mostrarResultados(librosPorIdioma);
                    }
                    break;

                case 4:
                    // Listar todos los libros
                    List<Book> todosLosLibros = bookService.getAllBooks();
                    mostrarResultados(todosLosLibros);
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo...");
                    break;

                default:
                    // Opción inválida
                    System.out.println("Opción inválida. Ingrese un número entre 1 y 5.");
            }
        } while (opcion != 5);
    }

    private void mostrarResultados(List<Book> libros) {
        if (libros.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            for (Book libro : libros) {
                System.out.println("Título: " + libro.getTitle());

                // Convierte la lista de autores en una cadena formateada
                String formattedAuthors = libro.getAuthors().stream()
                        .map(Author::toString) // Usa el método toString de Author
                        .collect(Collectors.joining(", ")); // Junta los autores con comas

                System.out.println("Autores: " + formattedAuthors);
                System.out.println(); // Línea en blanco para separar los libros
            }
        }
    }
}
