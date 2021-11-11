package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    PARAMETRO_INVALIDO("/paramentro-invalido", "Parâmetro inválido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
    ENTIDADE_EM_USO("/entidade-em-uso", "A entidade está em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "http://localhost:8080" + path;
        this.title = title;
    }

}
