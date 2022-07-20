package com.etnetera.hr;

import com.etnetera.hr.controller.JavaScriptFrameworkController;
import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class used for Spring Boot/MVC based tests.
 *
 * @author Etnetera
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JavaScriptFrameworkTests {

    @Autowired
    JavaScriptFrameworkController controller;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JavaScriptFrameworkRepository repository;

    @Before
    public void initData() {
        JavaScriptFramework react = new JavaScriptFramework();
        JavaScriptFramework angular = new JavaScriptFramework();

        react.setName("React");
        react.setHypeLevel(8);
        react.setVersion("1.8.9");
        react.setId(1L);

        angular.setName("Angular");
        angular.setHypeLevel(6);
        angular.setVersion("1.6");
        angular.setId(2L);

        repository.save(react);
        repository.save(angular);
    }

    @Test
    public void testGetById() throws Exception {
        this.mockMvc.perform(get("/frameworks/1")).andDo(print()).andExpect(content()
                .string(containsString("{\"id\":1,\"name\":\"React\",\"version\":\"1.8.9\",\"hypeLevel\":8,\"deprecationDate\":null}")));
    }

    @Test
    public void testGetByIdError() throws Exception {
        this.mockMvc.perform(get("/frameworks/15")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void testFindByName() throws Exception {
        this.mockMvc.perform(get("/frameworks/name/Angular")).andDo(print()).andExpect(content()
                .string(containsString("[{\"id\":2,\"name\":\"Angular\",\"version\":\"1.6\",\"hypeLevel\":6,\"deprecationDate\":null}]")));
    }

    @Test
    public void testFindByNameEmpty() throws Exception {
        this.mockMvc.perform(get("/frameworks/name/SpringBoot")).andDo(print()).andExpect(content()
                .string(containsString("[]")));
    }

    @Test
    public void testFindByHypeLevel() throws Exception {
        this.mockMvc.perform(get("/frameworks/hype-level/6")).andDo(print()).andExpect(content()
                .string(containsString("[{\"id\":2,\"name\":\"Angular\",\"version\":\"1.6\",\"hypeLevel\":6,\"deprecationDate\":null}]")));
    }

    @Test
    public void testFindByHypeLevelEmpty() throws Exception {
        this.mockMvc.perform(get("/frameworks/hype-level/16")).andDo(print()).andExpect(content()
                .string(containsString("[]")));
    }

    @Test
    public void testFindByVersion() throws Exception {
        this.mockMvc.perform(get("/frameworks/version/1.8.9")).andDo(print()).andExpect(content()
                .string(containsString("[{\"id\":1,\"name\":\"React\",\"version\":\"1.8.9\",\"hypeLevel\":8,\"deprecationDate\":null}]")));
    }

    @Test
    public void testFindByVersionEmpty() throws Exception {
        this.mockMvc.perform(get("/frameworks/version/25")).andDo(print()).andExpect(content()
                .string(containsString("[]")));
    }

    @Test
    @Transactional
    public void testDelete() throws Exception {
        this.mockMvc.perform(post("/frameworks/delete").param("id", "1")).andDo(print());
        this.mockMvc.perform(post("/frameworks/delete").param("id", "2")).andDo(print());
        this.mockMvc.perform(get("/frameworks")).andDo(print()).andExpect(content()
                .string(containsString("[]")));
    }

    @Test
    @Transactional
    public void testUpdate() throws Exception {
        this.mockMvc.perform(post("/frameworks/2/update").contentType(MediaType.APPLICATION_JSON).content("{\"id\":2,\"name\":\"Angular\",\"version\":\"1.6\",\"hypeLevel\":3,\"deprecationDate\":null}")).andDo(print()).andExpect(content()
                .string(containsString("{\"id\":2,\"name\":\"Angular\",\"version\":\"1.6\",\"hypeLevel\":3,\"deprecationDate\":null}")));
    }
}
