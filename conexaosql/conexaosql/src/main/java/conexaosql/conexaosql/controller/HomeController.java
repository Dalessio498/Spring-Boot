package conexaosql.conexaosql.controller;


import conexaosql.conexaosql.model.Usuario;
import conexaosql.conexaosql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    CRUD

//    CREATE

    @PostMapping("/salvar")
    public String salvar(@RequestParam("nome") String nome,@RequestParam("idade") Integer idade, @RequestParam("cpf") String cpf, @RequestParam("email") String email, @RequestParam("plano") String plano){
        Usuario novoUsuario = new Usuario(nome, idade, cpf, email, plano);
        usuarioRepository.save(novoUsuario);
        return "redirect:/";
    }

//    LISTAR

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "nome", required = false)String nomeBusca){
        List<Usuario> usuarios;

        if (nomeBusca != null && !nomeBusca.isEmpty()) {
            usuarios = usuarioRepository.findByNomeContaining(nomeBusca);
        }
        else {
            usuarios = usuarioRepository.findAll();
        }
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("nomeBusca", nomeBusca);
        return "/index";
    }

//      EXCLUIR

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id){
        usuarioRepository.deleteById(id);
        return "redirect:/";
    }

//      EDITAR

    // Abir formulario de edição

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable("id") Integer id, Model model){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id invalido " + id));

        model.addAttribute("Usuario ", usuario);
        return "editar";
    }

//      Salvar a edição

    @PostMapping("/atualizar/{id}")
    public String atualizarUsuario(@PathVariable("id") Integer id, @ModelAttribute("usuario") Usuario usuario) {
        usuario.setId(id);
        usuarioRepository.save(usuario);
        return "redirect:/";
    }

}
