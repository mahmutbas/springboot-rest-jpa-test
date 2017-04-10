package com.victoriasecret.mytest.model;

import com.victoriasecret.model.Girl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by TCMBAS on 10/04/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class GirlTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void testGirlNameIsNullShouldThrowException() throws Exception
    {
        Girl girl = new Girl(null);
    }
}
