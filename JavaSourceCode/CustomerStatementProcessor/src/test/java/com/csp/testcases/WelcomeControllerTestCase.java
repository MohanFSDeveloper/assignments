package com.csp.testcases;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.csp.controller.WelcomeController;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WelcomeController.class })
@WebAppConfiguration
public class WelcomeControllerTestCase {

    private MockMvc mockMvc;

    @Autowired 
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testExcelValidation() throws Exception {
    	  mockMvc.perform(get("/processStmnt/"));
    }

}
