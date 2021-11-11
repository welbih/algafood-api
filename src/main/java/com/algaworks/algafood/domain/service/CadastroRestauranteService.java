package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        var cozinha = verificarCozinha(restaurante.getCozinha().getId());
        restaurante.setCozinha(cozinha);
        return restauranteRepository.save(restaurante);
    }

    public Restaurante buscarOuFalhar(Long id) {
        return verificarRestaurante(id);
    }

    public void remover(Long id) {
        var restaurante = verificarRestaurante(id);
        restauranteRepository.delete(restaurante);
    }

    private Restaurante verificarRestaurante(Long id) {
        return restauranteRepository.findById(id).orElseThrow(() -> new RestauranteNaoEncontradoException(id));
    }

    private Cozinha verificarCozinha(Long id) {
        return cozinhaRepository
            .findById(id)
            .orElseThrow(
                () -> new CozinhaNaoEncontradaException(id));
    }

}
