package fatec.sp.optinoptout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.sp.optinoptout.entity.Historico;
import fatec.sp.optinoptout.service.HistoricoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/historico")
public class HistoricoController {

	@Autowired
	private HistoricoService historicoService;

	@GetMapping(value = "/all")
	public List<Historico> getAllHistoricos() {
		return historicoService.getAll();
	}

	@GetMapping(value = "/{id}")
	public Historico getHistoricoById(@PathVariable("id") long id) {
		return historicoService.getHistoricoById(id);
	}

	@GetMapping(value = "/usuario/{id}")
	public List<Historico> getHistoricoByUsuarioId(@PathVariable("id") Long usuarioId) {
		return historicoService.getHistoricoByUsuarioId(usuarioId);
	}

	@GetMapping(value = "/termo/{termo}")
	public List<Historico> getHistoricoByTermoVersao(@PathVariable("termo") Long termoVersao) {
		return historicoService.getHistoricoByTermoVersao(termoVersao);
	}

	@GetMapping(value = "/sms/{sms}")
	public List<Historico> getHistoricoBySms(@PathVariable("sms") boolean sms) {
		return historicoService.getHistoricoBySms(sms);
	}

	@GetMapping(value = "/whats/{whats}")
	public List<Historico> getHistoricoByUsuarioWhats(@PathVariable("whats") boolean whats) {
		return historicoService.getHistoricoByWhats(whats);
	}
	@GetMapping(value = "/ligacao/{ligacao}")
	public List<Historico> getHistoricoByUsuarioLigacao(@PathVariable("ligacao") boolean ligacao) {
		return historicoService.getHistoricoByLigacao(ligacao);
	}

}
