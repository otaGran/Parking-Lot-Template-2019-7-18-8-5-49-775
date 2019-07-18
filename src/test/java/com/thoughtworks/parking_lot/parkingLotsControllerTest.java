package com.thoughtworks.parking_lot;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.parking_lot.model.parkingLot;
import com.thoughtworks.parking_lot.repository.parkingLotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class parkingLotsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void contextLoads() {
    }


    private com.thoughtworks.parking_lot.repository.parkingLotRepository parkingLotRepository;

    @Transactional
    @Test
    public void should_return_parkingLot_when_post_to_API() throws Exception {
        parkingLot parkingLot = new parkingLot();
        parkingLot.setName("myHome");
        parkingLot.setCapacity(4);
        parkingLot.setLocation("Zhongshan");

        ObjectMapper objectMapper = new ObjectMapper();  // object转string

        ResultActions resultActions = mockMvc.perform(post("/parking-lots")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"name\":\"myHome\",\n" +
                        "\t\"capacity\":4,\n" +
                        "\t\"location\":\"zhongshan\"\n" +
                        "}"));
    }
}
