package com.victoriasecret.mytest.dao;

import com.victoriasecret.dao.GirlRepository;
import com.victoriasecret.model.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

/**
 * Created by TCMBAS on 07/04/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class GirlRepositoryTest
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GirlRepository girlRepository;

    @Test
    public void testFindSexyGirls()
    {
        Girl girl = new Girl("Sebnem");
/*        girl.setName("Sebnem");*/
        girl.setSurname("Schaefer");
        girl.setAge(23);
        girl.setWeigth(45L);
        girl.setHeigth(179L);
        girl = entityManager.persist(girl);

        List<Girl> girlList = girlRepository.findAll();
        assertThat(girlList).contains(girl);
        assertThat(girlList.size()).isGreaterThan(0);

    }
}
