package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    // @Autowired → Mesmo valor de um construtor
    // Construtor
    private MissoesRepository missoesRepository;

    // construtor
    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar todas as missoes
     public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // Criar uma nova missao
    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    // Listar todas as missoes por ID
    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    // Deletar missao - Tem que ser um método VOID

    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

    // Alterar Missão
    public MissoesModel alterarMissaoPorId(Long id, MissoesModel missao) {
        MissoesModel missaoExistente = missoesRepository.findById(id).get();
        missaoExistente.setNomeDaMissao(missao.getNomeDaMissao());
        missaoExistente.setDificuldade(missao.getDificuldade());
        missaoExistente.setNinjas(missao.getNinjas());
        return missoesRepository.save(missao);
    }

}
