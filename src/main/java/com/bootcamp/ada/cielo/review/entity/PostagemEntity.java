package com.bootcamp.ada.cielo.review.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="tb_postagem")
public final class PostagemEntity{
    @PrePersist
    public void prePersist() {
        this.dtPublicacao = new Date();
    }

        @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid_postagem")
    private UUID uuid;

    @NotNull
    @Column(name ="ds_publicacao")
    private String publicacao;

    @NotNull
    @Column(name ="nm_publicacao")
    private String nmPublicacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Column(name ="dt_publicacao")
    private Date dtPublicacao;

    @ManyToOne
    @JoinColumn(name ="tp_postagem")
    private TpPostagemEntity tpPostagem;

    @ManyToOne
    @JoinColumn(name ="uuid_cliente")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "uuid_empresa")
    private EmpresaEntity empresa;


}
