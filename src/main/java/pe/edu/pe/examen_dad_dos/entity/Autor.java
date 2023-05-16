package pe.edu.pe.examen_dad_dos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Autor {

    @Id
    @Column(name = "id_autor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;

    @Column(name = "nombre_autor")
    private String nombreAutor;

    @Column(name = "apellidos_autor")
    private String apellidosAutor;

    @Column(name = "pais_autor")
    private String paisAutor;

    @OneToMany(mappedBy="autor")
    private Set<Libro> libros;
}
