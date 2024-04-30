package com.interview.range.livingobjects.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.range.livingobjects.exception.LabelNotFoundException;
import com.interview.range.livingobjects.model.Label;
import com.interview.range.livingobjects.service.IMarchingLabelsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MarchingLablesController {

	private IMarchingLabelsService marchingLabelsService;

	@GetMapping("/matchingLabels")
	public ResponseEntity<Label[]> marchingLabels(@RequestParam int item) throws LabelNotFoundException {
		Label[] labels = marchingLabelsService.marchingLabels(item);
		return ResponseEntity.status(HttpStatus.OK).body(labels);
	}

}
