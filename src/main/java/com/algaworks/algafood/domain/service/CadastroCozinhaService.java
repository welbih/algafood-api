package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CadastroCozinhaService {

    private static final String MSG_COZINHA_EM_USO = "A entidade %d está em uso";

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar (Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public void excluir(Long id) {
        try {
            var cozinha = buscarOuFalhar(id);
            cozinhaRepository.delete(cozinha);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MSG_COZINHA_EM_USO, id));
        }
    }

    public Cozinha buscarOuFalhar(Long id) {
        return cozinhaRepository
            .findById(id)
            .orElseThrow(() -> new CozinhaNaoEncontradaException(id));
    }
}