package fatec.sp.optinoptout.service;

import fatec.sp.optinoptout.entity.Termo;
import java.util.List;

public interface TermoService {

    List<Termo> getAll();

    Termo getTermoById(long id);

    Termo postTermo(Termo termo);

    Termo getLatestTermo();
}
