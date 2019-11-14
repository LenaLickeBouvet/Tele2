package se.comhem.test.montyhall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MontyHallApplicationTests {

	@Autowired
	private SimulationController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}

	@Test
	public void shouldReturnOK() throws Exception {
		int noOfSims = 8888;
		this.mockMvc.perform(get("/simulations?noSimulations="
				+ noOfSims + "&switchDoorStrategy=true")).andExpect(status().isOk());
	}

	@Test
	public void toManySimulations_shouldReturn422Error() throws Exception {
		int noOfSims = 888888888;
		this.mockMvc.perform(get("/simulations?noSimulations="
				+ noOfSims + "&switchDoorStrategy=true")).andExpect(status().is4xxClientError());
	}

	@Test
	public void noArguments_shouldReturnError() throws Exception {
		this.mockMvc.perform(get("/simulations")).andExpect(status().is4xxClientError());

	}
}
