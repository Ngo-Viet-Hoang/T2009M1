package com.example.t2009m1.api;

import com.example.t2009m1.T2009M1Application;
import com.example.t2009m1.entity.Product;
import com.example.t2009m1.reponsitory.ProductReponsitory;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = T2009M1Application.class)
class ProductApiTest {
    MockMvc mockMvc;
    @Mock
    private ProductReponsitory productReponsitory;
    @InjectMocks
    private ProductApi productApi;
    @Before
    public void preTest(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(productApi)
                .build();
    }
    @Test
    public void requestBodyTest() {
        try {
            when(productApi.findAll()).thenReturn(productReponsitory.findAll());
            mockMvc
                    .perform(get("/api/v1/products")
                            .content(String.valueOf(new Product()))
                            .contentType("application/json"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
        }catch (Exception e){
            System.out.println("Exception:" + e);
        }
    }

}