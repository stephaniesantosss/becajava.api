
package br.universidade.app.repository;

//import org.springframework.data.repository.CrudRepository; 
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import br.universidade.app.model.*;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
