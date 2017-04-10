package com.victoriasecret.mytest.service;

import com.google.common.collect.Lists;
import com.victoriasecret.dao.GirlRepository;
import com.victoriasecret.model.Girl;
import com.victoriasecret.services.GirlsDatingService;
import com.victoriasecret.services.impl.GirlsDatingServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ReflectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;

/**
 * Created by TCMBAS on 07/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlDatingServiceTest
{
    @MockBean
    private GirlRepository girlRepositoryMock;

    private GirlsDatingServiceImpl girlsDatingService;

    @Before
    public void setUp()
    {
        girlRepositoryMock = Mockito.mock(GirlRepository.class);
        Girl girl = new Girl();
        girl.setId(3424L);
        girl.setName("Sebnem");
        girl.setSurname("Schaefer");
        girl.setAge(23);
        girl.setWeigth(45L);
        girl.setHeigth(179L);
        given(this.girlRepositoryMock.findAll()).willReturn(Lists.newArrayList(girl));
        girlsDatingService = new GirlsDatingServiceImpl(girlRepositoryMock);
        //  ReflectionUtils.setField(girlsDatingService,"girlRepository",girlRepositoryMock);,
    }

    @Test
    public void testFindAllGirls()
    {
        List<Girl> girls = this.girlsDatingService.findSexyGrils();
        Assert.assertNotNull(girls);
        Assertions.assertThat(girls.iterator().next().getAge()).isEqualTo(23);
    }

}
