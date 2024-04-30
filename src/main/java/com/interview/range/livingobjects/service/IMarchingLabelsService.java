package com.interview.range.livingobjects.service;


import com.interview.range.livingobjects.exception.LabelNotFoundException;
import com.interview.range.livingobjects.model.Label;

public interface IMarchingLabelsService {
	
	Label[] marchingLabels(int item) throws LabelNotFoundException;

}
