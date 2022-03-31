package fatec.sp.optinoptout.repository;

import fatec.sp.optinoptout.entity.Termo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermoRepository extends JpaRepository<Termo, Long>  {

  	Termo findTopByOrderByIdDesc();
}
