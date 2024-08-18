package programmerzamannow.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import programmerzamannow.restful.model.Proyek;

public interface ProyekLokasiRepository extends JpaRepository<Proyek, Long> {
}