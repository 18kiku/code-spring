package org.zerock.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class ReplyMapperTests {

    private Long[] bnoArr = {8192L, 8191L, 8190L, 8189L, 8188L};

    @Autowired
    private ReplyMapper mapper;

    @Test
    public void testMapper() {
        log.info(mapper);
    }

    @Test
    public void testCreate() {
        IntStream.range(1, 10).forEach(i -> {
            ReplyVO vo = new ReplyVO();

            vo.setBno(bnoArr[i%5]);
            vo.setReply("reply test " + i);
            vo.setReplyer("replyer" + i);

            mapper.insert(vo);
        });
    }

    @Test
    public void testRead() {
        Long targetRno = 5L;
        ReplyVO vo = mapper.read(targetRno);

        log.info(vo);
    }

    @Test
    public void testList() {
        Criteria cri = new Criteria();
        List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);

        for (ReplyVO reply : replies) {
            log.info(reply);

        }
    }

    @Test
    public void testList2() {
        Criteria cri = new Criteria(1, 10);
        List<ReplyVO> replyVOS = mapper.getListWithPaging(cri, 8191L);
        for (ReplyVO replyVO : replyVOS) {
            log.info(replyVO);

        }
    }
}
