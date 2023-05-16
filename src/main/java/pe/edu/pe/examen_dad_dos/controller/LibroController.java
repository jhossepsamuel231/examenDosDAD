package pe.edu.pe.examen_dad_dos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pe.edu.pe.examen_dad_dos.dto.LibroRequest;
import pe.edu.pe.examen_dad_dos.entity.Autor;
import pe.edu.pe.examen_dad_dos.entity.Editorial;
import pe.edu.pe.examen_dad_dos.entity.Libro;
import pe.edu.pe.examen_dad_dos.repository.AutorRepository;
import pe.edu.pe.examen_dad_dos.repository.EditorialRepository;
import pe.edu.pe.examen_dad_dos.repository.LibroRepository;

import java.util.List;

@Controller
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    @QueryMapping
    public List<Libro> listarLibro(){
        return libroRepository.findAll();
    }

    @QueryMapping
    public Libro listarLibroPorId(@Argument int id) {
        return libroRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Libro guardarLibro(@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autorId()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorialId()).orElse(null);
        Libro libroBD = new Libro();

        libroBD.setTituloLibro(libroRequest.tituloLibro());
        libroBD.setDescripcionLibro(libroRequest.descripcionLibro());
        libroBD.setPaginasLibro(libroRequest.paginasLibro());
        libroBD.setEdicionLibro(libroRequest.edicionLibro());
        libroBD.setAutor(autor);
        libroBD.setEditorial(editorial);

        return libroRepository.save(libroBD);
    }

    @MutationMapping
    public Libro actualizarLibro(@Argument int id ,@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autorId()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorialId()).orElse(null);
        Libro libroBD = new Libro();

        libroBD.setIdLibro(id);
        libroBD.setTituloLibro(libroRequest.tituloLibro());
        libroBD.setDescripcionLibro(libroRequest.descripcionLibro());
        libroBD.setPaginasLibro(libroRequest.paginasLibro());
        libroBD.setEdicionLibro(libroRequest.edicionLibro());
        libroBD.setAutor(autor);
        libroBD.setEditorial(editorial);

        return libroRepository.save(libroBD);
    }

    @MutationMapping
    public void eliminarLibro(@Argument int id) {
        libroRepository.deleteById(id);
    }
}
