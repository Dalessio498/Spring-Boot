package conexaosql.conexaosql.model;
import jakarta.persistence.*;
    @Entity

    @Table(name="usuarios")

public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;


        private String nome;
        private Integer idade;
        private String cpf;
        private String email;
        private String plano;

        public Usuario(){}

        public Usuario( String nome, Integer idade, String cpf, String email, String plano){
            this.nome = nome;
            this.idade = idade;
            this.cpf = cpf;
            this.email = email;
            this.plano = plano;
        }


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

        public Integer getIdade() {
            return idade;
        }

        public void setIdade(Integer idade) {
            this.idade = idade;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPlano() {
            return plano;
        }

        public void setPlano(String plano) {
            this.plano = plano;
        }



}
