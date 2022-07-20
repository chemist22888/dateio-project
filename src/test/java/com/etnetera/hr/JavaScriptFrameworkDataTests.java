package com.etnetera.hr;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

/**
 * Class used for Spring Boot/MVC based tests.
 *
 * @author Etnetera
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class JavaScriptFrameworkDataTests {
    @Autowired
    JavaScriptFrameworkRepository frameworkRepository;

    @Before
    public void initData() {
        JavaScriptFramework react = new JavaScriptFramework();
        JavaScriptFramework angular = new JavaScriptFramework();
        JavaScriptFramework angularNew = new JavaScriptFramework();

        react.setName("React");
        react.setHypeLevel(8);
        react.setVersion("1.8.9");
        react.setId(1L);
        react.setDeprecationDate(Date.valueOf("2022-01-15"));

        angular.setName("Angular");
        angular.setHypeLevel(6);
        angular.setVersion("1.6");
        angular.setId(2L);

        angularNew.setName("Angular");
        angularNew.setHypeLevel(8);
        angularNew.setVersion("1.9");
        angularNew.setId(3L);

        frameworkRepository.save(react);
        frameworkRepository.save(angular);
        frameworkRepository.save(angularNew);
    }

    @Test
    public void testFindByName() {
        List<JavaScriptFramework> result = frameworkRepository.findAllByName("Angular");

        Assert.assertEquals(2,
                result.size());

        result.forEach(framework ->
                Assert.assertEquals("Angular", framework.getName())
        );
    }

    @Test
    public void testFindByVersion() {
        List<JavaScriptFramework> result = frameworkRepository.findAllByVersion("1.9");

        Assert.assertEquals(1,
                result.size());

        result.forEach(framework ->
                Assert.assertEquals("1.9", framework.getVersion())
        );
    }

    @Test
    public void testFindByHypeLevel() {
        List<JavaScriptFramework> result = frameworkRepository.findAllByHypeLevel(6);

        Assert.assertEquals(1,
                result.size());

        result.forEach(framework ->
                Assert.assertEquals(Integer.valueOf(6), framework.getHypeLevel())
        );
    }
}
