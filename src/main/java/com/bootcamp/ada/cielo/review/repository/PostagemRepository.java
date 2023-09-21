package com.bootcamp.ada.cielo.review.repository;

import com.bootcamp.ada.cielo.review.entity.PostagemEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemEntity, UUID> {

List<PostagemEntity> findAllByOrderByDtPublicacao();
List<PostagemEntity> findByClienteUuid(UUID uuid);

}
