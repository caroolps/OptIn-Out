package fatec.sp.optinoptout.service;

import fatec.sp.optinoptout.entity.Termo;
import fatec.sp.optinoptout.repository.TermoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("termoService")
public class TermoServiceImpl implements TermoService {

    @Autowired
    private TermoRepository termoRepository;

    public List<Termo> getAll() {
        return termoRepository.findAll();
    }

    public Termo getTermoById(long id) {
        Optional<Termo> termo = termoRepository.findById(id);
        if (termo.isPresent()) {
            return termo.get();
        }
        throw new RuntimeException("Termo not found");
    }

    @Transactional
    public Termo postTermo(Termo termo) {
        termo.setdCriacao(new Date());
        return termoRepository.save(termo);
    }

    @Override
    public Termo getLatestTermo() {
        return termoRepository.findTopByOrderByIdDesc();
    }

}
