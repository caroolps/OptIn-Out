package fatec.sp.optinoptout.controller;

import java.util.List;

import fatec.sp.optinoptout.vo.UsuarioConfigVO;
import fatec.sp.optinoptout.vo.UsuarioTermoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.sp.optinoptout.entity.Usuario;
import fatec.sp.optinoptout.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/all")
	public List<Usuario> getAllUsuarios() {
		return usuarioService.getAll();
	}

	@GetMapping(value = "/{id}")
	public Usuario getUsuario(@PathVariable("id") long id) {
		return usuarioService.getUsuarioById(id);
	}

	@GetMapping(value = "config/{id}")
	public UsuarioConfigVO getUsuarioConfig(@PathVariable("id") long id) {
		return usuarioService.getUsuarioConfig(id);
	}

	@GetMapping(value = "termo/{id}")
	public UsuarioTermoVO getUsuarioTermo(@PathVariable("id") long id) {
		return usuarioService.getUsuarioTermo(id);
	}

	@PostMapping(value = "/new")
	public Usuario postUsuario(@RequestBody Usuario usuario) {
		return usuarioService.postUsuario(usuario);
	}

	@PutMapping(value = "/edit")
	public Usuario putUsuario(@RequestBody Usuario usuario) {
		return usuarioService.putUsuario(usuario);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable("id") Long id) {
		usuarioService.deleteUsuarioById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
