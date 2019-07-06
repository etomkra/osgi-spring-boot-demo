package by.kolodyuk.osgi.springboot.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.hamcrest.Matchers.containsString
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(value = SimpleController.class, secure = false)
class SimpleControllerTest extends Specification {
    @Autowired
    private MockMvc mockMvc

    def "should return echo"() {
        expect:
        mockMvc.perform(get("/echo"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("echo")))
    }
}
