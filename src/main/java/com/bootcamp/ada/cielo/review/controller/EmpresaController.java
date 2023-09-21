package com.bootcamp.ada.cielo.review.controller;


import com.bootcamp.ada.cielo.review.entity.EmpresaEntity;
import com.bootcamp.ada.cielo.review.model.Empresa;
import com.bootcamp.ada.cielo.review.repository.EmpresaRepository;
import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping("empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping()
    public ResponseEntity<Empresa> criarEmpresa(@Valid  @RequestBody Empresa empresa){
        EmpresaEntity empresaEntity = EmpresaEntity.builder()
                .cnpj(empresa.getCnpj())
                .nomeFantasia(empresa.getNomeFantasia())
                .email(empresa.getEmail()).build();
        empresaEntity = empresaRepository.saveAndFlush(empresaEntity);
        empresa.setUuid(empresaEntity.getUuid());
        return ResponseEntity.ok().body(empresa);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<EmpresaEntity> buscarEmpresaPorId(@PathVariable("uuid") UUID idEmpresa){
        return ResponseEntity.ok().body(empresaRepository.getReferenceById(idEmpresa));
    }



    @GetMapping("/all")
    public ResponseEntity<List<EmpresaEntity>> buscarEmpresas(){
        return ResponseEntity.ok().body(empresaRepository.findAll());
    }



}
