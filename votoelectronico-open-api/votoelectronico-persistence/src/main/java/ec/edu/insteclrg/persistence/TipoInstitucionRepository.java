package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.TipoInstitucion;

@Repository
public interface TipoInstitucionRepository extends JpaRepository<TipoInstitucion, Long> {

	Optional<TipoInstitucion> findById(long id);
}
