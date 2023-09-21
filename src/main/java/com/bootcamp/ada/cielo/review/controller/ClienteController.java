package com.bootcamp.ada.cielo.review.controller;


import com.bootcamp.ada.cielo.review.entity.ClienteEntity;
import com.bootcamp.ada.cielo.review.model.Cliente;
import com.bootcamp.ada.cielo.review.repository.ClienteRepository;
import jakarta.validation.Valid;
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
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping()
    public ResponseEntity criarCliente(@Valid @RequestBody Cliente cliente){
        try {
            ClienteEntity clienteEntity = ClienteEntity.builder()
                    .nome(cliente.getNome())
                    .email(cliente.getEmail())
                    .dataNascimento(cliente.getDataNascimento()).build();
            clienteEntity.setNome(cliente.getNome());
            clienteEntity.setEmail(cliente.getEmail());
            clienteEntity.setDataNascimento(cliente.getDataNascimento());
            clienteEntity = clienteRepository.saveAndFlush(clienteEntity);
            cliente.setUuid(clienteEntity.getUuid());
            return ResponseEntity.ok().body(cliente);
        } catch (Exception e ){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity buscarClientePorId(@PathVariable("uuid") UUID idCliente){
        return ResponseEntity.ok().body(clienteRepository.getReferenceById(idCliente));
    }






}
