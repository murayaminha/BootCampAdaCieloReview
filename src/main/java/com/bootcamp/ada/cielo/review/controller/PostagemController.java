package com.bootcamp.ada.cielo.review.controller;

import com.bootcamp.ada.cielo.review.entity.ClienteEntity;
import com.bootcamp.ada.cielo.review.entity.EmpresaEntity;
import com.bootcamp.ada.cielo.review.entity.PostagemEntity;
import com.bootcamp.ada.cielo.review.entity.TpPostagemEntity;
import com.bootcamp.ada.cielo.review.model.Elogio;
import com.bootcamp.ada.cielo.review.model.Reclamacao;
import com.bootcamp.ada.cielo.review.repository.ClienteRepository;
import com.bootcamp.ada.cielo.review.repository.PostagemRepository;
import jakarta.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publicacao")
public class PostagemController {

    @Autowired
    PostagemRepository postagemRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    @RequestMapping("/reclamacao")
    public ResponseEntity publicarReclamacao( @Valid @RequestBody Reclamacao reclamacao){
        PostagemEntity postagem = new PostagemEntity();
        postagem.setNmPublicacao(reclamacao.getNmPublicacao());
        postagem.setPublicacao(reclamacao.getPublicacao());
        postagem.setTpPostagem(TpPostagemEntity.builder().tpPostagem(1l).build());
        postagem.setCliente( ClienteEntity.builder().uuid(reclamacao.getCliente().getUuid()).build());
        postagem.setEmpresa(EmpresaEntity.builder().uuid(reclamacao.getEmpresa().getUuid()).build());
        postagemRepository.save(postagem);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @RequestMapping("/elogio")
    public ResponseEntity publicarElogio( @Valid @RequestBody Elogio elogio){
        PostagemEntity postagem = new PostagemEntity();
        postagem.setNmPublicacao(elogio.getNmPublicacao());
        Timestamp tms = new Timestamp(System.currentTimeMillis());
        Date date = new Date(tms.getTime());
        postagem.setPublicacao(elogio.getPublicacao());
        postagem.setTpPostagem(TpPostagemEntity.builder().tpPostagem(2l).build());
        postagem.setCliente( ClienteEntity.builder().uuid(elogio.getCliente().getUuid()).build());
        postagem.setEmpresa(EmpresaEntity.builder().uuid(elogio.getEmpresa().getUuid()).build());
        postagemRepository.save(postagem);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity buscarPostagens(){
        return ResponseEntity.ok().body(postagemRepository.findAll());
    }

    @GetMapping
    @RequestMapping("/ordenada")
    public ResponseEntity buscarPostagensOrdenada(){
        return ResponseEntity.ok().body(postagemRepository.findAllByOrderByDtPublicacao());
    }

    @GetMapping
    @RequestMapping("/porCliente/{uuid}")
    public ResponseEntity buscarPostagensPorCliente(@PathVariable("uuid")UUID uuid){
        return ResponseEntity.ok().body(postagemRepository.findByClienteUuid(uuid));
    }
}
