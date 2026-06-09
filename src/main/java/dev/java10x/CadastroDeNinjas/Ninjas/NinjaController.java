package dev.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjasService ninjasService;

    // Construtor
    public NinjaController(NinjasService ninjasService) {
        this.ninjasService = ninjasService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjasService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas ninja (CREATE)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjasService.listarNinjas();
    }

    // Mostar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id) {
        return ninjasService.listarninjaPorId(id);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        return ninjasService.alterarNinjaPorId(id, ninja);
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjasService.deletarNinjaPorId(id);
    }




}
