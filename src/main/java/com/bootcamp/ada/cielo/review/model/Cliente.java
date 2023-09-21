package com.bootcamp.ada.cielo.review.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Stack;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public final class Cliente extends Usuario implements Idade {

    private UUID uuid;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private Stack<Postagem> postagens;

    @Override
    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    private UUID gerarUuid(){
        return UUID.randomUUID();
    }

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
