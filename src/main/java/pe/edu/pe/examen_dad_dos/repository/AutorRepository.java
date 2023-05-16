package pe.edu.pe.examen_dad_dos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.examen_dad_dos.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
