package programmerzamannow.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import programmerzamannow.restful.model.Proyek;

public interface ProyekRepository extends JpaRepository<Proyek, Long> {
}