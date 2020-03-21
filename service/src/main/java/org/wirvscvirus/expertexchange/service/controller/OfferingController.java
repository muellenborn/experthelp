package org.wirvscvirus.expertexchange.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/expert-exchange/v1")
@Api(tags = { "expert-exchange" })
public class OfferingController {
    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Documentation goes here", notes = "And you can also add notes")
    public ResponseEntity<?> getCategories() {
        LocalDate now = LocalDate.now();

        return ResponseEntity.ok("hello world, it's " + now.toString());
    }


}
