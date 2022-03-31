package fatec.sp.optinoptout.service;

import fatec.sp.optinoptout.entity.Termo;
import fatec.sp.optinoptout.entity.Usuario;
import fatec.sp.optinoptout.repository.UsuarioRepository;
import fatec.sp.optinoptout.vo.UsuarioConfigVO;
import fatec.sp.optinoptout.vo.UsuarioTermoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TermoService termoService;
    @Autowired
    private HistoricoService historicoService;

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override

    public Usuario getUsuarioById(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new RuntimeException("User not found");
    }

    @Override
    @Transactional
    public Usuario postUsuario(Usuario usuario) {
        validarUsuario(usuario);
        validarTermoDoUsuario(usuario);

        usuario.setdCriacao(new Date());
        usuario.setdAtualizacao(new Date());

        Usuario usuarioCadastrado = usuarioRepository.save(usuario);

        historicoService.salvarHistoricoTipoConfiguracao(usuarioCadastrado);
        historicoService.salvarHistoricoTipoTermo(usuarioCadastrado);

        return usuarioCadastrado;

    }

    @Override
    public void deleteUsuarioById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioConfigVO getUsuarioConfig(long id) {
        Usuario usuario = getUsuarioById(id);

        UsuarioConfigVO usuarioConfigVO = new UsuarioConfigVO();
        usuarioConfigVO.setLigacao(usuario.getLigacao());
        usuarioConfigVO.setWhats(usuario.getWhats());
        usuarioConfigVO.setSms(usuario.getSms());

        return usuarioConfigVO;
    }

    @Override
    public UsuarioTermoVO getUsuarioTermo(long id) {
        Usuario usuario = getUsuarioById(id);

        UsuarioTermoVO usuarioTermoVO = new UsuarioTermoVO();
        usuarioTermoVO.setTermoVersao(usuario.getTermoVersao());
        return usuarioTermoVO;
    }

    @Override
    public Usuario putUsuario(Usuario newUsuario) {
        validarUsuario(newUsuario);
        validarTermoDoUsuario(newUsuario);

        Usuario usuario = usuarioRepository.getById(newUsuario.getId());

        if (usuario == null) {
            throw new RuntimeException("Usuario não encontrado");
        }

        usuario.setNome(newUsuario.getNome());
        usuario.setEmail(newUsuario.getEmail());
        usuario.setCpf(newUsuario.getCpf());
        usuario.setCelular(newUsuario.getCelular());
        usuario.setRua(newUsuario.getRua());
        usuario.setNumero(newUsuario.getNumero());
        usuario.setBairro(newUsuario.getBairro());
        usuario.setCidade(newUsuario.getCidade());
        usuario.setCep(newUsuario.getCep());
        usuario.setdAtualizacao(new Date());

        if (usuario.getTermoVersao() != newUsuario.getTermoVersao()) {
            usuario.setTermoVersao(newUsuario.getTermoVersao());
            historicoService.salvarHistoricoTipoTermo(usuario);
        }

        if (usuario.getSms() != (newUsuario.getSms())
                || usuario.getWhats() != (newUsuario.getWhats())
                || usuario.getLigacao() != (newUsuario.getLigacao())) {
            usuario.setSms(newUsuario.getSms());
            usuario.setWhats(newUsuario.getWhats());
            usuario.setLigacao(newUsuario.getLigacao());
            historicoService.salvarHistoricoTipoConfiguracao(usuario);
        }

        return usuarioRepository.save(usuario);
    }

    private void validarUsuario(Usuario usuario) {
        if (usuario.getTermoVersao() == null) {
            throw new RuntimeException("Termo não pode ser nulo");
        }
    }

    private void validarTermoDoUsuario(Usuario usuario) {
        Termo termoAceitoPeloUsuario = termoService.getTermoById(usuario.getTermoVersao());
        Termo termoMaisRecente = termoService.getLatestTermo();
        if (termoAceitoPeloUsuario == null) {
            throw new RuntimeException("Usuario tentando aceitar um termo não existente");
        }

        if (termoMaisRecente.getId() != usuario.getTermoVersao()) {
            throw new RuntimeException("Usuario tentando aceitar um termo antigo");
        }

    }
}
