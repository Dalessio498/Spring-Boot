package br.com.tutorial.conexao_mysql.controller;
import br.com.tutorial.conexao_mysql.model.Usuario;
import br.com.tutorial.conexao_mysql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
public class HomeController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    /**
     * Listar Todos e Busca
     */
    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "nome", required = false) String nomeBusca) {
        List<Usuario> usuarios;
        if (nomeBusca != null && !nomeBusca.isEmpty()) {
            usuarios = usuarioRepository.findByNomeContaining(nomeBusca);
        } else {
            usuarios = usuarioRepository.findAll();
        }
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("nomeBusca", nomeBusca);
        return "index";
    }
    /**
     * Salvar (Cadastro Novo)
     */
    @PostMapping("/salvar")
    public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email) {
        Usuario novoUsuario = new Usuario(nome, email);
        usuarioRepository.save(novoUsuario);
        return "redirect:/";
    }
    /**
     * Excluir Usuário
     */
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        usuarioRepository.deleteById(id);
        return "redirect:/";

    } // <--- O método excluir FECHA AQUI agora.
// -------------------------------------------------------
// NOVOS MÉTODOS (Agora estão fora do método excluir)
// -------------------------------------------------------
    /**
     * Abrir formulário de Edição
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("usuario", usuario);
        return "editar"; // Requer o arquivo editar.html
    }
    /**
     * Salvar a Edição (Update)
     */
    @PostMapping("/atualizar/{id}")
    public String atualizarUsuario(@PathVariable("id") Integer id, @ModelAttribute("usuario") Usuario usuario) {
        usuario.setId(id); // Garante o UPDATE mantendo o ID original
        usuarioRepository.save(usuario);
        return "redirect:/";
    }
}