package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class NinjasService {

   // @Autowired // Mesmo valor de inicializar um construtor // é uma boa prática não iniciar com annotation
    private NinjaRepository ninjaRepository;

    // Construtor
    public NinjasService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar todos os ninjas por ID
    public NinjaModel listarninjaPorId(long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return  ninjaPorId.orElse(null);
    }

    // Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Deletar ninja - Tem que ser um método VOID
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Alterar Ninja
    public NinjaModel alterarNinjaPorId(Long id, NinjaModel ninja) {
        // Busca o ninja existente direto pelo ID
        NinjaModel ninjaExistente = ninjaRepository.findById(id).get();
        // Atualiza os dados básicos
        ninjaExistente.setNome(ninja.getNome());
        ninjaExistente.setEmail(ninja.getEmail());
        ninjaExistente.setImgUrl(ninja.getImgUrl());
        ninjaExistente.setIdade(ninja.getIdade());
        // ADICIONE ESSA LINHA AQUI: atualiza também a missão vinculada
        ninjaExistente.setMissoes(ninja.getMissoes());
        // Salva o mesmo ninja com a missão certa de volta
        return ninjaRepository.save(ninja);
    }





}
