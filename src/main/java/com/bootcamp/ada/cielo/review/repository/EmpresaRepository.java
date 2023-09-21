package com.bootcamp.ada.cielo.review.repository;

import com.bootcamp.ada.cielo.review.entity.ClienteEntity;
import com.bootcamp.ada.cielo.review.entity.EmpresaEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, UUID> {



}
