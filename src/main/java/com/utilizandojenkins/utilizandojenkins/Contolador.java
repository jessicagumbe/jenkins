package com.utilizandojenkins.utilizandojenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Contolador {

    @GetMapping()
    public String Ola(){
        return "Ola, Mundo";
    }
}