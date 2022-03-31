package fatec.sp.optinoptout.service;

import fatec.sp.optinoptout.entity.Usuario;
import fatec.sp.optinoptout.vo.UsuarioConfigVO;
import fatec.sp.optinoptout.vo.UsuarioTermoVO;

import java.util.List;

public interface UsuarioService {

	List<Usuario> getAll();

	Usuario getUsuarioById(long id);

	Usuario postUsuario(Usuario usuario);

	Usuario putUsuario(Usuario newUsuario);

     void deleteUsuarioById(Long id);

	UsuarioConfigVO getUsuarioConfig(long id);

	UsuarioTermoVO getUsuarioTermo(long id);
}
