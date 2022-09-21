package org.zerock.service;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:web/WEB-INF/applicationContext.xml"})
public class SampleTxServiceTests {

    @Autowired
    private SampleTxService service;

    @Test
    public void testLong() {
        String str = "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n" +
                "Starry\r\n";
        log.info(str.getBytes().length);

        service.addData(str);
    }

}