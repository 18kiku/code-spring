package org.zerock.sample;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class SampleTests {

    @Autowired
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertNotNull(restaurant);

        System.out.println(restaurant);
        System.out.println(restaurant.getChef());
        log.info(restaurant);
        log.info("-----------");
        log.info(restaurant.getChef());

    }
}
