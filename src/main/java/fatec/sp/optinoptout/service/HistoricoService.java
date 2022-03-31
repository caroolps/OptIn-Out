package fatec.sp.optinoptout.service;

import java.util.List;

import fatec.sp.optinoptout.entity.Historico;
import fatec.sp.optinoptout.entity.Usuario;

public interface HistoricoService {

    List<Historico> getAll();

    Historico getHistoricoById(long id);

    List<Historico> getHistoricoByUsuarioId(Long usuarioId);

    List<Historico> getHistoricoByTermoVersao(Long termoVersao);

    List<Historico> getHistoricoBySms(boolean sms);

    List<Historico> getHistoricoByWhats(boolean whats);

    List<Historico> getHistoricoByLigacao(boolean ligacao);

    Historico salvarHistoricoTipoTermo(Usuario usuario);

    Historico salvarHistoricoTipoConfiguracao(Usuario usuario);

}
