package pe.edu.pe.examen_dad_dos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Libro {

    @Id
    @Column(name = "id_libro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @Column(name = "titulo_libro")
    private String tituloLibro;

    @Column(name = "descripcion_libro")
    private String descripcionLibro;

    @Column(name = "paginas_libro")
    private Long paginasLibro;

    @Column(name = "edicion_libro")
    private String edicionLibro;

    @ManyToOne
    @JoinColumn(name="idAutor", nullable=false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name="idEditorial", nullable=false)
    private Editorial editorial;
}
