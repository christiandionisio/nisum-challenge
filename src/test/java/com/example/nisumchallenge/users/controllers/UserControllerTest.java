package com.example.nisumchallenge.users.controllers;

import com.example.nisumchallenge.users.dtos.PhoneDto;
import com.example.nisumchallenge.users.dtos.UserResponseDto;
import com.example.nisumchallenge.users.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  void createUserTestOk() throws Exception {
    Mockito.when(userService.createUser(Mockito.any()))
      .thenReturn(getDummyUserResponseDto());

    mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content(getRequestCreateDtoStringDummy()))
      .andExpect(MockMvcResultMatchers.status().isCreated())
      .andExpect(MockMvcResultMatchers.header().string("Location", "http://localhost/api/users/"
        .concat(getDummyUserResponseDto().getId())))
      .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(getDummyUserResponseDto().getId()))
      .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(getDummyUserResponseDto().getEmail()));
  }

  private UserResponseDto getDummyUserResponseDto() {
    return UserResponseDto.builder()
      .id("sdgagsdgs")
      .name("Christian")
      .email("christian@gmail.com")
      .isActive(Boolean.TRUE)
      .phones(List.of(PhoneDto.builder()
          .id(1)
          .number("999888777")
        .build()))
      .build();
  }

  private String getRequestCreateDtoStringDummy() {
    return """
          {
              "name": "Christian",
              "email": "christian@gmail.com",
              "password": "asda$Asads",
              "phones": [
                  {
                      "number": "999888777",
                      "cityCode": "1",
                      "countryCode": "51"
                  }
              ]
          }""";
  }

}