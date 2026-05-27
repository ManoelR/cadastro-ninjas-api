package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    // @Autowired // Mesmo valor de um construtor
    private MissoesRepository missoesRepository;

    // construtor
    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar todos os ninjas
     public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

}
