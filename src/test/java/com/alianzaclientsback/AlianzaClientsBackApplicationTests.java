package com.alianzaclientsback;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alianzaclientsback.model.Client;
import com.alianzaclientsback.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AlianzaClientsBackApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ClientRepository clientRepository;
	

	@DisplayName("Test List Clients")
	@Test
    public void shouldReturnDefaultListClient() throws Exception {
		
        this.mockMvc.perform(get("/api/client"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.length()").value(clientRepository.getNUMBER_OF_CLIENT()));
    }
	
	@DisplayName("Test List Empty Clients ")
	@Test
	public void shouldReturnEmptyListClient()  throws Exception {
		clientRepository.setNUMBER_OF_CLIENT(0);
		clientRepository.initializeListClient();
		
		this.mockMvc.perform(get("/api/client"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(clientRepository.getNUMBER_OF_CLIENT()));

	}
	
	@DisplayName("Test Create Client")
	@Test
    public void shouldCreateNewClient() throws Exception {
		Client client = new Client();
		client.setEmail("emailTesting");
		client.setName("nameTesting");
		client.setPhone("+1234567");
		client.setStartDate("2021/12/12");
		

	       this.mockMvc.perform(post("/api/client")
	                .content(asJsonString(client))
	                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.codeClient").exists())
	                .andDo(MockMvcResultHandlers.print());
		//System.out.println(" code created "+MockMvcResultMatchers.jsonPath("$.codeClient").toString());
		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
