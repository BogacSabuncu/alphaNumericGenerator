package com.bogac.alphaNumericGenerator.controllers;

import com.bogac.alphaNumericGenerator.services.AlphaNumericGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AlphaNumericGeneratorController {

    @Autowired
    private AlphaNumericGeneratorService alphaNumericGeneratorService;

    @RequestMapping(method = RequestMethod.GET, value = "/alphaNumeric/{number}")
    public ResponseEntity<?> getProduct(@PathVariable String number){
        System.out.println(number);
        return new ResponseEntity<>(alphaNumericGeneratorService.generateCombos(number), HttpStatus.OK);
    }

}
