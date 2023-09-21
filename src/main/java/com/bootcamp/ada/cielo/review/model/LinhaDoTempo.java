package com.bootcamp.ada.cielo.review.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LinhaDoTempo {

    private List<Postagem> postagems;
}
