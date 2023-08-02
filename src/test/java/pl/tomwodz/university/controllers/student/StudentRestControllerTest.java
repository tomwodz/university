package pl.tomwodz.university.controllers.student;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.tomwodz.university.controllers.student.dto.response.GetStudentResponseDto;
import pl.tomwodz.university.database.IStudentRepository;
import pl.tomwodz.university.model.Student;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
class StudentRestControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IStudentRepository studentRepository;

    @Test
    void shouldGetAllStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/university/students/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    private final Student testStudent = new Student("Test","Test","Test","Test","Test","Test");
    private final TestStudentDto testStudentDto  = new TestStudentDto("TestPost", "TestPost", "Test", "Test", "Test", "Test");

    @Test
    void shouldGetStudentById() throws Exception {
        studentRepository.save(testStudent);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/university/students/" + testStudent.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        GetStudentResponseDto getStudentResponseDto = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), GetStudentResponseDto.class);
        assertThat(getStudentResponseDto.student().getId()).isEqualTo(testStudent.getId());
    }

    @Test
    void shouldDeleteStudentById() throws Exception {
        studentRepository.save(testStudent);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/university/students/" + testStudent.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
    }

    @Test
    void shouldAddStudent() throws Exception {
        TestStudentDto testStudentDto  = new TestStudentDto("TestPost", "TestPost", "Test", "Test", "Test", "Test");
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/university/students")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(testStudentDto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        GetStudentResponseDto getStudentResponseDto = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), GetStudentResponseDto.class);
        assertThat(getStudentResponseDto.student().getName()).isEqualTo("TestPost");
        assertThat(getStudentResponseDto.student().getSurname()).isEqualTo("TestPost");
    }

    @Test
    void shouldExchangeStudentById() throws Exception {
        studentRepository.save(testStudent);
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/university/students/" + testStudent.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(testStudentDto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
    }


}