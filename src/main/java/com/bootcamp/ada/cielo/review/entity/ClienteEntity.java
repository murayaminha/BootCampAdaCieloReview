package com.bootcamp.ada.cielo.review.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Stack;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity
@Table(name="tb_cliente", uniqueConstraints ={@UniqueConstraint( columnNames = "ds_email")} )
public final class ClienteEntity extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid_cliente")
    private UUID uuid;

    @NotBlank(message = "Nome é obrigatório")
    @NotNull
    @Column(name = "nm_cliente")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @NotNull
    @Email
    @Column(name = "ds_email")
    private String email;

    @NotNull
    @Column(name = "dt_nascto")
    private LocalDate dataNascimento;


    @Override
    public String toString() {
        return "Cliente{" +
                "uuid=" + uuid +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

}
