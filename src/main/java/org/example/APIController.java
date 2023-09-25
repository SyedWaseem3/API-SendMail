package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    List<Integer>  listInteger;
    @GetMapping("name")
    public List<Integer> getName(){
        String value = "Waseem";
        MailHandlerBase.sendMail(value);
        return listInteger;
    }

    @PostMapping("add/{x}")
    public String addNumbers(@PathVariable Integer x){
        listInteger.add(x);
        return x + " added.";
    }
}
