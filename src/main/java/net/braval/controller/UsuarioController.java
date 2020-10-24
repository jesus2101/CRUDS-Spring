package net.braval.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.braval.model.DetallesUsuario;
import net.braval.model.Pedido;
import net.braval.model.Usuario;
import net.braval.repository.IPedidoRepository;
import net.braval.repository.IUsuarioRepository;
import net.braval.service.IUsuarioService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	IUsuarioService serviceUsuario;
	
	@Autowired
	IPedidoRepository pedidoRepo;
	
	@Autowired
	IUsuarioRepository usuarioRepo;
	
	
	@GetMapping("/formulario")
	public String formulario(Model model) {
		
		Usuario usuario=new Usuario();
		DetallesUsuario detallesUsuario=new DetallesUsuario();
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("detalles",detallesUsuario);
		
		return "formularioUsuario";
		
	}
	
	@PostMapping("/guardar")
	public void guardar(@ModelAttribute("usuario")Usuario usuario) {
		
		System.out.println(usuario);
		serviceUsuario.registrarUsuario(usuario);
		
	}
	
	
	@GetMapping("/formPedido")
	public String formPedido(Model model) {
		
		Pedido pedido=new Pedido();
		
		model.addAttribute("pedido", pedido);
		
		return "formularioPedido";
	}
	
	@PostMapping("/registrarPedido")
	public String registrarPedido(@ModelAttribute("pedido")Pedido elPedido) {
		
		
	Optional<Usuario> optional=usuarioRepo.findById(elPedido.getUsuario().getId());
		    if(optional.isPresent()) {
			Usuario usuario=optional.get();
			usuario.agregarPedido(elPedido);
			pedidoRepo.save(elPedido);	
		}
		
		  return "redirect:/usuario/formPedido";
	}
	
	
	

}
