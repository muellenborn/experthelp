package org.wirvsvirus.expertexchange.service.controller;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/expert-exchange/v1")
@Api(tags = { "expert-exchange" })
public class FooController {
	@GetMapping(value = "/foo", produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Documentation goes here", notes = "And you can also add notes")
	public ResponseEntity<?> foo() {
		LocalDate now = LocalDate.now();

		return ResponseEntity.ok("hello world, it's " + now.toString());
	}
}
