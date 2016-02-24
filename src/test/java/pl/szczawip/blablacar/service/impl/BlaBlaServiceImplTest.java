package pl.szczawip.blablacar.service.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.szczawip.blablacar.config.Config;
import pl.szczawip.blablacar.config.TestProperties;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, TestProperties.class})
public class BlaBlaServiceImplTest extends AbstractBlaBlaServiceTests{
}
