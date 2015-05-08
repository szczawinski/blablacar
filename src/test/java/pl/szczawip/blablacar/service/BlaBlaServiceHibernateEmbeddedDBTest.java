package pl.szczawip.blablacar.service;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.szczawip.blablacar.config.HibetnateEmbeddedDBConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibetnateEmbeddedDBConfig.class})
public class BlaBlaServiceHibernateEmbeddedDBTest extends AbstractBlaBlaServiceTests{


    @Autowired
    SchemaExport schemaExport;

    @Before
    public  void setup(){
        schemaExport.drop(true,true);
        schemaExport.create(true, true);

    }


}
