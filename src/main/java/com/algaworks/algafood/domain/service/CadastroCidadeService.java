package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.CidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    private static final String MSG_CIDADE_NAO_ENCONTRADO = "Cidade de código %d não encontrado";

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService estadoService;

    public Cidade salvar(Cidade cidade) {
        var estado = estadoService.buscarOuFalhar(cidade.getEstado().getId());
        cidade.setEstado(estado);
        return cidadeRepository.save(cidade);
    }

    public void remover(Long id) {
        try {
            var cozinha = buscarOuFalhar(id);
            cidadeRepository.delete(cozinha);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("A entidade %d está em uso", id));
        }
    }

    public Cidade buscarOuFalhar(Long id) {
        return verificarCidade(id);
    }

    private Cidade verificarCidade(Long id) {
        return cidadeRepository
            .findById(id)
            .orElseThrow(
                () -> new CidadeNaoEncontradaException(id));
    }
}
