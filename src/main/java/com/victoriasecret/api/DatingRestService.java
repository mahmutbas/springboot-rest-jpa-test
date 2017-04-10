package com.victoriasecret.api;

import com.victoriasecret.model.Girl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by TCMBAS on 06/04/2017.
 */
@RequestMapping(path = "/api")
public interface DatingRestService
{
    @RequestMapping(path = "/girls/bestof", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Girl> findSexyGirls();
}
