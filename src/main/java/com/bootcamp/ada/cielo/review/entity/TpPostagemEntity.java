package com.bootcamp.ada.cielo.review.entity;

import com.bootcamp.ada.cielo.review.model.Postagem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
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
@Table(name="tb_tp_postagem")
public final class TpPostagemEntity {

    @Id
    @Column(name = "tp_postagem")
    private Long tpPostagem;

    @Column(name ="ds_tp_postagem")
    private String dsTpPostagem;



}
