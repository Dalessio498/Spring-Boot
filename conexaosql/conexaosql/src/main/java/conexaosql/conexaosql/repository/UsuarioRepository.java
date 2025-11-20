package conexaosql.conexaosql.repository;
import conexaosql.conexaosql.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 1. Diga qual Entidade ela gerencia (Usuario)
// 2. Diga qual o tipo da Chave Primária (Integer, do campo 'id')
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNomeContaining(String nomeBusca);
// Nada mais é necessário!
// O Spring Data JPA implementa todos os métodos para nós.
}