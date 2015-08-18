package pl.szczawip.blablacar.misc;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by szczawip on 4/23/2015.
 */
public class CloudFoundryDBTest {


    @Test
    @Ignore
    public void testName() throws Exception {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://babar.elephantsql.com:5432/crmqylzt");
        dataSource.setUsername("crmqylzt");
        dataSource.setPassword("PVXqTBAIQNsM-UGmFOSmTvYjp688-lOg");


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.queryForList("SELECT * from ride");


    }
}
