package ac.rs.metropolitan.it355pzback.repository;

import ac.rs.metropolitan.it355pzback.entity.Repertoar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepertoarRepository extends JpaRepository<Repertoar, Long> {
}
