package fatec.sp.optinoptout.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import fatec.sp.optinoptout.entity.Usuario;
import fatec.sp.optinoptout.enums.TipoHistorico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.sp.optinoptout.entity.Historico;
import fatec.sp.optinoptout.repository.HistoricoRepository;

@Service("historicoService")
public class HistoricoServiceImpl implements HistoricoService {

	@Autowired
	private HistoricoRepository historicoRepository;

	public Historico salvarHistoricoTipoTermo(Usuario usuario) {
		Historico historico = new Historico();
		historico.setUsuario(usuario);
		historico.setData(new Date());
		historico.setTermoVersao(usuario.getTermoVersao());
		historico.setTipoHistorico(TipoHistorico.TERMO);
		return historicoRepository.save(historico);
	}

	public Historico salvarHistoricoTipoConfiguracao(Usuario usuario) {
		Historico historico = new Historico();
		historico.setUsuario(usuario);
		historico.setData(new Date());
		historico.setTipoHistorico(TipoHistorico.CONFIGURACAO);
		historico.setLigacao(usuario.getLigacao());
		historico.setSms(usuario.getSms());
		historico.setWhats(usuario.getWhats());
		return historicoRepository.save(historico);
	}

	@Override
	public List<Historico> getAll() {
		return historicoRepository.findAll();
	}

	@Override
	public Historico getHistoricoById(long id) {
		Optional<Historico> historico = historicoRepository.findById(id);
		if (historico.isPresent()) {
			return historico.get();
		}
		throw new RuntimeException("Historico not found");
	}

	@Override
	public List<Historico> getHistoricoByUsuarioId(Long usuarioId) {
		return historicoRepository.findByUsuarioId(usuarioId);
	}

	@Override
	public List<Historico> getHistoricoByTermoVersao(Long termoVersao) {
		return historicoRepository.findByTermoVersao(termoVersao);
	}

	@Override
	public List<Historico> getHistoricoBySms(boolean sms) {
		return historicoRepository.findBySms(sms);
	}

	@Override
	public List<Historico> getHistoricoByWhats(boolean whats) {
		return historicoRepository.findByWhats(whats);
	}

	@Override
	public List<Historico> getHistoricoByLigacao(boolean ligacao) {
		return historicoRepository.findByLigacao(ligacao);
	}

}
