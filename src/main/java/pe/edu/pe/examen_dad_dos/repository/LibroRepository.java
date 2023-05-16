package pe.edu.pe.examen_dad_dos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.examen_dad_dos.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
