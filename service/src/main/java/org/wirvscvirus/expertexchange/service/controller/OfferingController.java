package org.wirvscvirus.expertexchange.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wirvscvirus.expertexchange.service.model.KnowhowCategory;
import org.wirvscvirus.expertexchange.service.srv.MetadataService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expert-exchange/v1")
@Api(tags = { "expert-exchange" })
public class OfferingController {

    private final MetadataService metadataService;

    public OfferingController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Documentation goes here", notes = "And you can also add notes")
    public ResponseEntity<?> getCategories() {

        List<KnowhowCategory> knowhowCategories = metadataService.getKnowHowCategories();

        if (!knowhowCategories.isEmpty()) {
            return ResponseEntity.of(Optional.of(knowhowCategories.get(0)));
        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }


}
