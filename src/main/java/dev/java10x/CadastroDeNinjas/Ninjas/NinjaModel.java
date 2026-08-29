package dev.java10x.CadastroDeNinjas.Ninjas;


import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


// JPA = Java Persistence API
// Entity ele transforma uma classe comum em uma entidade do Banco de dados
@Entity
@Table(name = "tb_cadastro")
//@Data // Criar os GETTERS e SETTERS automáticamente //Estava dando conflito e não aparecia a listados ninjas. getters e setters criados para resolver.
//@NoArgsConstructor // Criar construtor sem argumentos // O Lombok faz automáticamente
//@AllArgsConstructor // Criar construtor com todos os argumentos // ^-^
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column(unique = true) // coluna de e-mail única. O e-mail será único por usuário
    private String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;

    @Column (name = "idade")
    private int idade;

    // @ManyToOne -- um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")  // @JoinColumn -- Vai juntar a coluna de missoes com a de ninja // missoes_id -- Foreing key ou chave estrangeira.
    private MissoesModel missoes;



    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
