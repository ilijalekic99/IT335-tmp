package ac.rs.metropolitan.it355pzback.repository;

import ac.rs.metropolitan.it355pzback.entity.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {
}
