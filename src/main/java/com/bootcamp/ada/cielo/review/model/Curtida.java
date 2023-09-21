package com.bootcamp.ada.cielo.review.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curtida {

    private Cliente cliente;
    private Postagem postagem;

}
