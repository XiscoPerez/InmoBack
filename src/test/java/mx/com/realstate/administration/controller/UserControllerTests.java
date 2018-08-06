package mx.com.realstate.administration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import mx.com.realstate.administration.dto.UserDto;
import mx.com.realstate.administration.utils.RealStateUtils;

/**
 * The Class TipoCambioControllerTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    /** The mock mvc. */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Consultar empty test.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void createUserEmptyTest() throws Exception {
        UserDto userDto = new UserDto();
        mockMvc.perform(post("/realstate/user").contentType(MediaType.APPLICATION_JSON_VALUE).content(RealStateUtils.requestJson(userDto))).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void createUserTest() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("XiscoPerez");
        userDto.setPassword("Password");
        userDto.setEmail("xisco.perez18@gmail.com");
        mockMvc.perform(post("/realstate/user").contentType(MediaType.APPLICATION_JSON_VALUE).content(RealStateUtils.requestJson(userDto))).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void userExistTest() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("XiscoPerez");
        userDto.setPassword("Password");
        userDto.setEmail("xisco.perez18@gmail.com");
        mockMvc.perform(post("/realstate/user").contentType(MediaType.APPLICATION_JSON_VALUE).content(RealStateUtils.requestJson(userDto))).andDo(print()).andExpect(status().isBadRequest());

    }

}
