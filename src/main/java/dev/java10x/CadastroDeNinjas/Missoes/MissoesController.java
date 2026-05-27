package dev.java10x.CadastroDeNinjas.Missoes;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // É uma rota para as API's
@RequestMapping("/missoes") // Mapeia as API's
public class MissoesController {

    private MissoesService missoesService;

    // Construtor
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -- Manda uma requisição para mostrar as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // POST -- Usuário manda uma requisição para criar as missões
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso";
    }

    // PUT -- Manda uma requisição para alterar as missões
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso";
    }

    // DELETE -- Manda uma requisição para deletar a missão
    @DeleteMapping("/Deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso";
    }
}
