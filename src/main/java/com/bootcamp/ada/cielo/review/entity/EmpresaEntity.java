package com.bootcamp.ada.cielo.review.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tb_empresa")
public final class EmpresaEntity extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid_Empresa")
    private UUID uuid;

    @NotNull
    @CNPJ
    @Column(name = "ds_cnpj")
    private String cnpj;

    @NotNull
    @Column(name = "nm_fantasia")
    private String nomeFantasia;

    @Email
    @NotNull
    @Column(name = "ds_email")
    private String email;

}
