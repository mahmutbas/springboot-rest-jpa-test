package com.victoriasecret.api.impl;

import com.victoriasecret.api.DatingRestService;
import com.victoriasecret.model.Girl;
import com.victoriasecret.services.GirlsDatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by TCMBAS on 06/04/2017.
 */
@RestController
public class DatingRestController implements DatingRestService
{
    @Autowired
    private GirlsDatingService girlsDatingService;

    //Rest  service

    @Override
    public List<Girl> findSexyGirls()
    {
        return girlsDatingService.findSexyGrils();
    }
}
