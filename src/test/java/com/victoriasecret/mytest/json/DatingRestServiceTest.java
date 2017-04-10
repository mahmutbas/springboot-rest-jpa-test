package com.victoriasecret.mytest.json;

import com.victoriasecret.model.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by TCMBAS on 09/04/2017.
 */
@RunWith(SpringRunner.class)
@JsonTest
public class DatingRestServiceTest
{
    @Autowired
    private JacksonTester<Girl> girlJson;

    @Test
    public void testGirlJsonwithFile() throws Exception
    {
        Girl girl = new Girl();
        girl.setId(83432L);
        girl.setName("Sebnem");
        girl.setSurname("Schaefer");
        girl.setAge(23);
        girl.setWeigth(45L);
        girl.setHeigth(179L);

       /* assertThat(this.girlJson.write(girl)).isEqualToJson("test.json");
        System.out.println( girlJson.write(girl).getJson());*/

        assertThat(this.girlJson.write(girl)).hasJsonPathStringValue("@.name");
        assertThat(this.girlJson.write(girl)).extractingJsonPathStringValue("@.name").isEqualTo("Sebnem");
    }

    @Test
    public void testGirlJsonwithJsonObject() throws Exception
    {
        Girl girl = new Girl();
        girl.setId(83432L);
        girl.setName("Sebnem");
        girl.setSurname("Schaefer");
        girl.setAge(23);
        girl.setWeigth(45L);
        girl.setHeigth(179L);

        String content="{\"id\":83432,\"name\":\"Sebnem\",\"surname\":\"Schaefer\",\"age\":23,\"weigth\":45,\"heigth\":179}";
        assertThat(this.girlJson.parse(content)).isEqualTo(girl);
        assertThat(this.girlJson.parseObject(content).getSurname()).isEqualTo("Schaefer");
    }

}
