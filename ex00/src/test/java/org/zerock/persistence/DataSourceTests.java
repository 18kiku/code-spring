package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class DataSourceTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testMyBatis() {

        try (
            SqlSession session = sqlSessionFactory.openSession();
            Connection con = session.getConnection();
        ) {
            System.out.println(session);
            System.out.println(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConnection() {

        try {
            Connection con = dataSource.getConnection();

            log.info(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
