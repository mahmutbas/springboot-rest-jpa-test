package com.victoriasecret.services.impl;

import com.victoriasecret.dao.GirlRepository;
import com.victoriasecret.model.Girl;
import com.victoriasecret.services.GirlsDatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by TCMBAS on 06/04/2017.
 */
@Component(value = "GirlsDatingService")
public class GirlsDatingServiceImpl implements GirlsDatingService
{
    private final GirlRepository girlRepository;

    @Autowired
    public GirlsDatingServiceImpl(GirlRepository girlRepository)
    {
        this.girlRepository = girlRepository;
    }

    @Override
    public List<Girl> findSexyGrils()
    {
        return girlRepository.findAll();
    }
}
