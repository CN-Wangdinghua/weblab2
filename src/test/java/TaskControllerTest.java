import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import wdh17204222.Application;
import wdh17204222.rest.Task;
import wdh17204222.rest.TaskController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, TaskController.class})
@AutoConfigureMockMvc
public class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void test() throws Exception{
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/task/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.containsString("17204222")))
                .andReturn();
        ObjectMapper mapper = new ObjectMapper();
        String jsonstr = result.getResponse().getContentAsString();
        Task task = mapper.readValue(jsonstr, Task.class);
        Assert.assertNotNull(task);
        Assert.assertTrue(task.getName().contains("17204222")&&task.getId()==1);
    }
}
