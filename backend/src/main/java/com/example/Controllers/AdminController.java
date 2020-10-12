package com.example.Controllers;

import com.example.Models.TestErgebnis;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @RequestMapping(method = RequestMethod.POST, value="/sendErgebis")
    @CrossOrigin(origins = "http://localhost:3000")
    public String addTopic(@RequestBody TestErgebnis test){
        return "Ok";
    }
}
