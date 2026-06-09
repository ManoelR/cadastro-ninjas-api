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
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissao(missao);
    }

    // Mostar missao por ID (READ)
    @PutMapping("/listar/{id}")
    public MissoesModel listarmissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    // PUT -- Manda uma requisição para alterar as missões (UPDATE)
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesModel missao) {
        return missoesService.alterarMissaoPorId(id, missao);
    }

    // DELETE -- Manda uma requisição para deletar a missão
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }
}
