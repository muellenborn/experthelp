package org.wirvscvirus.expertexchange.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/expert-exchange/v1")
public class FooController {

    @GetMapping(value = "/foo")
    public String foo() {
        LocalDate now = LocalDate.now();

        return "hello world, it's " + now.toString();
    }

}
