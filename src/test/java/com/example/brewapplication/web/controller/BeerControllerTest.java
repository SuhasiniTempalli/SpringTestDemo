package com.example.brewapplication.web.controller;

import com.example.brewapplication.services.BeerService;
import com.example.brewapplication.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BeerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
    private BeerService beerService;

    @Test
    void getBeerById() throws Exception {
      BeerDto beerDto=new BeerDto();
      when(beerService.getBeerById(UUID.randomUUID())).thenReturn(beerDto);
      mockMvc.perform(get("/api/v1/beer/"+UUID.randomUUID()))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.beerName").value("Galaxy Cat"))
              .andExpect(jsonPath("$.upc").value(3435345L));
    }

  @Test
  void saveNewBeer() throws Exception{
      String jsonPayload = "{\"beerName\":\"Galaxy\",\"beerStyle\":\"Pale Ale\",\"upc\":342344}";
      mockMvc.perform(post("/api/v1/beer/")
                    .contentType(MediaType.APPLICATION_JSON)  // Set Content-Type to JSON for the request
                    .accept(MediaType.APPLICATION_JSON)       // Expect JSON response
                    .content(jsonPayload.toString()))                    // Add request body
            .andExpect(status().isCreated());
                           // Assert status


  }

  @Test
  void updateBeer() throws Exception{
    String jsonPayload = "{\"beerName\":\"Galaxy\",\"beerStyle\":\"Pale Ale\",\"upc\":342344}";
    mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/{beerId}",UUID.randomUUID())
                    .contentType(MediaType.APPLICATION_JSON)  // Set Content-Type to JSON for the request
                    .accept(MediaType.APPLICATION_JSON)      // Expect JSON response
                    .content(jsonPayload)).andExpect(status().isNoContent());
    // Assert status


  }

  @Test
  void deleteBeer() throws Exception{
    String jsonPayload = "{\"beerName\":\"Galaxy\",\"beerStyle\":\"Pale Ale\",\"upc\":342344}";
    mockMvc.perform(delete("/api/v1/beer/{beerId}",UUID.randomUUID())
            .contentType(MediaType.APPLICATION_JSON)  // Set Content-Type to JSON for the request
            .accept(MediaType.APPLICATION_JSON)      // Expect JSON response
            .content(jsonPayload)).andExpect(status().isNoContent());
    // Assert status


  }




}