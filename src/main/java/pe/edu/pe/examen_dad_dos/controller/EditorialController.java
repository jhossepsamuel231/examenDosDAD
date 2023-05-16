package pe.edu.pe.examen_dad_dos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pe.edu.pe.examen_dad_dos.entity.Autor;
import pe.edu.pe.examen_dad_dos.entity.Editorial;
import pe.edu.pe.examen_dad_dos.repository.EditorialRepository;

import java.util.List;

@Controller
public class EditorialController {

    @Autowired
    private EditorialRepository editorialRepository;

    @QueryMapping
    public List<Editorial> listarEditorial(){
        return editorialRepository.findAll();
    }

    @QueryMapping
    public Editorial listarEditorialPorId(@Argument int id) {
        return editorialRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Editorial guardarEditorial(@Argument Editorial editorial) {
        Editorial editorialBD = new Editorial();

        editorialBD.setNombreEditorial(editorial.getNombreEditorial());
        editorialBD.setPaisEditorial(editorialBD.getPaisEditorial());

        return editorialRepository.save(editorialBD);
    }

    @MutationMapping
    public Editorial actualizarEditorial(@Argument int idEditorial ,@Argument Editorial editorial) {
        Editorial editorialBD = new Editorial();

        editorialBD.setIdEditorial(idEditorial);

        editorialBD.setNombreEditorial(editorial.getNombreEditorial());
        editorialBD.setPaisEditorial(editorialBD.getPaisEditorial());

        return editorialRepository.save(editorialBD);
    }

    @MutationMapping
    public void eliminarEditorial(@Argument int idEditorial) {
        editorialRepository.deleteById(idEditorial);
    }
}
