package com.example.QuestionsAPI;

import com.example.Models.AddUser;
import com.example.Models.TestErgebnis;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    private int pageVisited = 0;
    @RequestMapping(method = RequestMethod.POST, value="/sendErgebis")
    @CrossOrigin(origins = "http://localhost:3000")
    public String addTopic(@RequestBody TestErgebnis test){
        return "Ok";
    }

    @RequestMapping(method = RequestMethod.POST, value="/addVisit")
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
