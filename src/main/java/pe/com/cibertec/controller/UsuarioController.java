package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.mode.entity.UsuarioEntity;
import pe.com.cibertec.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UsuarioController {
	private final UsuarioService usuarioService;

	@GetMapping("/registrar_usuario")
	public String mostrarRegistrarUsuario(Model model) {
		model.addAttribute("usuario", new UsuarioEntity());
		return "registrar_usuario";
	}

	@PostMapping("/registrar_usuario")
	public String registrarUsuario(@ModelAttribute("usuario") UsuarioEntity usuarioEntity,
			@RequestParam("foto") MultipartFile foto, Model model) {
		usuarioService.crearUsuario(usuarioEntity, foto);

		// Agregar un mensaje de éxito, si es necesario
		model.addAttribute("registroCorrecto", "Usuario registrado exitosamente.");

		// Redirigir al login después de un registro exitoso
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String mostrarLogin(Model model) {
		model.addAttribute("usuario", new UsuarioEntity());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("usuario") UsuarioEntity usuarioFormulario, Model model, HttpSession session) {

		boolean usuarioValidado = usuarioService.validarUsuario(usuarioFormulario);
		if (usuarioValidado) {
			session.setAttribute("usuario", usuarioFormulario.getCorreo());
			return "redirect:/productos/";
		}

		model.addAttribute("loginInvalido", "No existe el usuario");
		model.addAttribute("usuario", new UsuarioEntity());
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}
}
