package pe.edu.pe.examen_dad_dos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pe.edu.pe.examen_dad_dos.entity.Autor;
import pe.edu.pe.examen_dad_dos.repository.AutorRepository;

import java.util.List;

@Controller
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @QueryMapping
    public List<Autor> listarAutores(){
        return autorRepository.findAll();
    }

    @QueryMapping
    public Autor listarAutorPorId(@Argument int id) {
        return autorRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Autor guardarAutor(@Argument Autor autor) {
        Autor autorBD = new Autor();

        autorBD.setNombreAutor(autor.getNombreAutor());
        autorBD.setApellidosAutor(autor.getApellidosAutor());
        autorBD.setPaisAutor(autor.getPaisAutor());

        return autorRepository.save(autorBD);
    }

    @MutationMapping
    public Autor actualizarAutor(@Argument int idAutor ,@Argument Autor autor) {
        Autor autorBD = new Autor();

        autorBD.setIdAutor(idAutor);
        autorBD.setNombreAutor(autor.getNombreAutor());
        autorBD.setApellidosAutor(autor.getApellidosAutor());
        autorBD.setPaisAutor(autor.getPaisAutor());

        return autorRepository.save(autorBD);
    }

    @MutationMapping
    public void eliminarAutor(@Argument int idAutor) {
        autorRepository.deleteById(idAutor);
    }
}
