package wdh17204222.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private Task task;
    @GetMapping("/task/{id}")
    public Task task(@PathVariable(value = "id") int id) {
        List<String> tasks = new ArrayList<String>();
        for (int i=1; i<=id; i++){
            tasks.add("17204222_" + i + " 王丁华_" + i);
        }
        return new Task(id, tasks.get(id-1));
    }
}
