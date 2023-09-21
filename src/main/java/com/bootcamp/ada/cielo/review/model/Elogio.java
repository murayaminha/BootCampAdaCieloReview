package com.bootcamp.ada.cielo.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public final class Elogio extends Postagem {


    private String publicacao;
    private String nmPublicacao;
    private String dtPublicacao;
    private Cliente cliente;
    private Empresa empresa;
}
