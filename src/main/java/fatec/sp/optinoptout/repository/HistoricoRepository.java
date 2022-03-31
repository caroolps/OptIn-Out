package fatec.sp.optinoptout.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.sp.optinoptout.entity.Historico;
import org.springframework.data.jpa.repository.Query;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    @Query("SELECT h FROM Historico h where h.usuario.id = ?1")
    List<Historico> findByUsuarioId(Long id);

    List<Historico> findByTermoVersao(Long termoVersao);

    List<Historico> findBySms(boolean sms);

    List<Historico> findByWhats(boolean whats);

    List<Historico> findByLigacao(boolean ligacao);
}
