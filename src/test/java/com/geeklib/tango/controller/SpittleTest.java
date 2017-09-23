package com.geeklib.tango.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class SpittleTest
{

	@Test
	public void shouldShowRecentSpittles() throws Exception
	{
		HelloworldController helloworldController = new HelloworldController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(helloworldController).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/helloworld")).andExpect(MockMvcResultMatchers.view().name("hello"));
				
		
	}
	
}
