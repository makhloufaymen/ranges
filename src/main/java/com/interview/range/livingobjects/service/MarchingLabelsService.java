package com.interview.range.livingobjects.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.interview.range.livingobjects.exception.LabelNotFoundException;
import com.interview.range.livingobjects.model.Label;
import com.interview.range.livingobjects.model.Range;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MarchingLabelsService implements IMarchingLabelsService {

	private List<Range> ranges;

	public MarchingLabelsService() {
		this.ranges = new ArrayList<>();
		// Initialize ranges here
		ranges.add(new Range("A", 0, 6));
		ranges.add(new Range("B", 5, 7));
	}

	/**
	 * check if is matching or not
	 * 
	 * @param item
	 * @throws LabelNotFoundException
	 */
	@Override
	public Label[] marchingLabels(int item) throws LabelNotFoundException {
		Label[] labels = ranges.stream().filter(range -> range.contains(item))
				.map(range -> new Label(range.getLabelName())).toArray(Label[]::new);

		if (labels == null) {
			throw new LabelNotFoundException("Range not found for " + item);
		}
		return labels;
	}

}
