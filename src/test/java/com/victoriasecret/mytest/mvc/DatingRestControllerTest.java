package com.victoriasecret.mytest.mvc;

/**
 * Created by TCMBAS on 09/04/2017.
 */

import com.google.common.collect.Lists;
import com.victoriasecret.api.impl.DatingRestController;
import com.victoriasecret.model.Girl;
import com.victoriasecret.services.impl.GirlsDatingServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DatingRestController.class)
public class DatingRestControllerTest
{
    @Autowired
    private MockMvc mvc;

    @MockBean
    private GirlsDatingServiceImpl girlsDatingService;

    @Test
    public void testfindSexyGirls() throws Exception
    {
        Girl girl = new Girl();
        girl.setId(83432L);
        girl.setName("Sebnem");
        girl.setSurname("Schaefer");
        girl.setAge(23);
        girl.setWeigth(45L);
        girl.setHeigth(179L);

        given(this.girlsDatingService.findSexyGrils()).willReturn(Lists.newArrayList(girl));

        this.mvc.perform(get("/api/girls/bestof").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string("[{\"id\":83432,\"name\":\"Sebnem\",\"surname\":\"Schaefer\",\"age\":23,\"weigth\":45,\"heigth\":179}]"));
    }

    @Test
    public void testHtmlUnitfindSexyGirls() throws Exception
    {
        Girl girl = new Girl();
        girl.setId(83432L);
        girl.setName("Sebnem");
        girl.setSurname("Schaefer");
        girl.setAge(23);
        girl.setWeigth(45L);
        girl.setHeigth(179L);

        given(this.girlsDatingService.findSexyGrils()).willReturn(Lists.newArrayList(girl));

   //      HtmlPage page=this.webClient.getPage("/api/girls/bestof");
     //    assertThat(page.getBody().getTextContent()).isEqualTo("[{\"id\":83432,\"name\":\"Sebnem\",\"surname\":\"Schaefer\",\"age\":23,\"weigth\":45,\"heigth\":179}]");
    }

}
