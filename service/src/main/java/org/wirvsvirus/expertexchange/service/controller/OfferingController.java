package org.wirvsvirus.expertexchange.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wirvsvirus.expertexchange.service.model.KnowhowCategory;
import org.wirvsvirus.expertexchange.service.repositories.KnowHowCategoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expert-exchange/v1")
public class OfferingController {

    @Autowired
    KnowHowCategoryRepository knowHowCategoryRepository;

    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Documentation goes here", notes = "And you can also add notes")
    public ResponseEntity<?> getCategories() {

        List<KnowhowCategory> knowhowCategories = knowHowCategoryRepository.findAll();

        if (!knowhowCategories.isEmpty()) {
            return ResponseEntity.of(Optional.of(knowhowCategories.get(0)));
        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }


}
