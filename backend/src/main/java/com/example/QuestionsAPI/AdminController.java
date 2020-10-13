package com.example.QuestionsAPI;

import com.example.Models.AddUser;
import com.example.Models.TestErgebnis;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    private int pageVisited = 0;
    
    @PostMapping("/sendErgebis")
    @CrossOrigin(origins = "http://localhost:3000")
    public String addTopic(@RequestBody TestErgebnis test){
        return "Ok";
    }

    @PostMapping("/addVisit")
    @CrossOrigin(origins = "http://localhost:3000")
    public String addSiteVisit(@RequestBody AddUser add){
        pageVisited+=add.getAdd();
        return "Ok";
    }

    @GetMapping("/getAmountVisited")
    @CrossOrigin(origins = "http://localhost:3000")
    public int getAmountVisited(){
        return pageVisited;
    }
}
