package com.bootcamp.ada.cielo.review.entity;

import com.bootcamp.ada.cielo.review.model.Postagem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tb_curtida")
public class CurtidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curtida")
    private Long id;

    @ManyToOne
    @JoinColumn(name ="uuid_cliente")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name ="uuid_postagem")
    private PostagemEntity postagem;

}
