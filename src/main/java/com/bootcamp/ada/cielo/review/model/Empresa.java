package com.bootcamp.ada.cielo.review.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public final class Empresa extends Usuario {

    private UUID uuid;
    private String cnpj;
    private String nomeFantasia;
    private String email;
}
