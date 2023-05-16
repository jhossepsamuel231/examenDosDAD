package pe.edu.pe.examen_dad_dos.dto;

import jakarta.persistence.Column;

public record LibroRequest(
        Integer id,
        String tituloLibro,
        String descripcionLibro,
        Long paginasLibro,
        String edicionLibro,
        int autorId,
        int editorialId
) {
}
