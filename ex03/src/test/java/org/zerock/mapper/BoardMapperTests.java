package org.zerock.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class BoardMapperTests {

    @Autowired
    BoardMapper mapper;

    @Test
    public void testGetList() {
        for (BoardVO boardVO : mapper.getList()) {
            log.info(boardVO);
        }
    }
}
