package br.com.tutorial.conexao_mysql.model;
import jakarta.persistence.*;
// 1. @Entity -> Diz ao JPA que esta classe é uma tabela
@Entity
// 2. @Table(name = "usuarios") -> Diz o nome exato da tabela no MySQL
@Table(name = "usuarios")
public class Usuario {
    // 3. @Id -> Marca como chave primária
    @Id
// 4. @GeneratedValue -> Avisa que o banco (AUTO_INCREMENT)
// vai gerar esse valor.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 5. Nomes das colunas.
// Se os nomes forem idênticos (Java 'nome' e SQL 'nome'),
// a anotação @Column é opcional.
    private String nome;
    private String email;
    // 6. O JPA precisa de um construtor vazio
    public Usuario() {
    }
    // 7. Construtor para facilitar a criação (sem o ID)
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    // 8. Crie Getters e Setters para TODOS os campos
// (A IDE pode gerar isso para você: Alt+Insert -> Getters and Setters)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}