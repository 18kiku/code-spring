package org.zerock.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class BoardMapperTests {

    @Autowired
    private BoardMapper mapper;

    @Test
    public void testGetList() {
        log.info("-----");
        mapper.getList().forEach(boardVO -> log.info(boardVO));
    }

    @Test
    public void testInsert() {

        BoardVO board = new BoardVO();
        board.setTitle("new title");
        board.setContent("new content");
        board.setWriter("newbie");

        mapper.insert(board);

        log.info(board);
    }

    @Test
    public void testInsertSelectKey() {

        BoardVO board = new BoardVO();
        board.setTitle("new title select key");
        board.setContent("new content select key");
        board.setWriter("newbie");

        mapper.insertSelectKey(board);

        log.info(board);
    }

    @Test
    public void testRead() {
        BoardVO board = mapper.read(5L);
    }

    @Test
    public void testDelete() {
        mapper.delete(8L);
    }

    @Test
    public void testUpdate() {
        BoardVO board = new BoardVO();
        board.setBno(5L);
        board.setTitle("update title");
        board.setContent("update content");
        board.setWriter("user00");

        int count = mapper.update(board);
        log.info("UPDATE COUNT: " + count);
    }

    @Test
    public void testPaging() {
        Criteria cri = new Criteria();

        cri.setPageNum(3);
        cri.setAmount(10);
        List<BoardVO> list = mapper.getListWithPaging(cri);

        list.forEach(boardVO -> log.info(boardVO));
    }
}
