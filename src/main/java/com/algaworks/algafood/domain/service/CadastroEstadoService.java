package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    private static final String MSG_ESTADO_EM_USO = "Estado de código %d em uso";

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void remover(Estado estado) {
        try {
            estadoRepository.delete(estado);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MSG_ESTADO_EM_USO, estado.getId()));
        }
    }

    public Estado buscarOuFalhar(Long id) {
        return verificarEstado(id);
    }

    private Estado verificarEstado(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new EstadoNaoEncontradoException(id));
    }
}
