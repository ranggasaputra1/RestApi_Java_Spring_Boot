package programmerzamannow.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import programmerzamannow.restful.model.Lokasi;

public interface LokasiRepository extends JpaRepository<Lokasi, Long> {
}
