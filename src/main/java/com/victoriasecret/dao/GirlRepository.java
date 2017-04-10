package com.victoriasecret.dao;

import com.victoriasecret.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TCMBAS on 06/04/2017.
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl, Long>
{
    List<Girl> findAll();
}
