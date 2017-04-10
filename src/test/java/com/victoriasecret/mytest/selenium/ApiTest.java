package com.victoriasecret.mytest.selenium;


import com.google.common.collect.Lists;
import com.victoriasecret.api.impl.DatingRestController;
import com.victoriasecret.model.Girl;
import com.victoriasecret.services.impl.GirlsDatingServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.*;


/**
 * Created by TCMBAS on 10/04/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DatingRestController.class)
public class ApiTest
{
    /*@Autowired
    WebDriver webDriver;
*/
    @MockBean
    private GirlsDatingServiceImpl girlsDatingService;


    @Test
    public void findGirlReturnGirl() throws Exception
    {
        Girl girl = new Girl("Sebnem");
        girl.setId(83432L);
        girl.setSurname("Schaefer");
        girl.setAge(23);
        girl.setWeigth(45L);
        girl.setHeigth(179L);

        given(this.girlsDatingService.findSexyGrils()).willReturn(Lists.newArrayList(girl));

        System.setProperty("webdriver.ie.driver", "D:\\IntelliJ\\date-service\\src\\test\\java\\com\\victoriasecret\\mytest\\selenium\\res\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();

   /*   System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ\\date-service\\src\\test\\java\\com\\victoriasecret\\mytest\\selenium\\res\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();*/

     /*   WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "D:\\IntelliJ\\date-service\\src\\test\\java\\com\\victoriasecret\\mytest\\selenium\\res\\geckodriver.exe");
        driver =new FirefoxDriver();*/

        webDriver.get("http://localhost:8080/api/girls/bestof");
       // webDriver.navigate().to("http://localhost:8080/api/girls/bestof.html");
        assertThat(webDriver.getTitle()).contains("WebDriver");

    }


}
