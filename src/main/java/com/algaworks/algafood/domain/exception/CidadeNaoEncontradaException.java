package com.algaworks.algafood.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

    public CidadeNaoEncontradaException(String mensagem ) {
        super(mensagem);
    }

    public CidadeNaoEncontradaException(Long id) {
        this(String.format("Não existe um cadastro de cidade com o código %d", id));
    }

}
