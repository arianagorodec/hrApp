package com.hrproj;

import com.hrproj.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("nikpetrov@gmail.com")
//@TestPropertySource("/application-test.properties")
//@Sql(value = {"/create-user-before.sql", "/create-candidate-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/create-user-after.sql", "/create-candidate-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @Test
    public void userPageTest() throws Exception{
        this.mockMvc.perform(get("/user"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(model().attribute("email", equalTo("nikpetrov@gmail.com")));
//                .andExpect(xpath("/html/body/div/div[2]/div[3]/div/div/div/section/div/div/div/div/div/ul[1]/li[3]/a").string("nikpetrov@gmail.com"));
    }
}
