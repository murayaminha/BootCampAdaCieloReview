package com.bootcamp.ada.cielo.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mensagem {
    public String mensagem;
    public Usuario usuario;
}
