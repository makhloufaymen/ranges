package com.interview.range.livingobjects.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Range {
	private String labelName;
	private int  lowerBound;
	private int  upperBound ;
	
	public boolean contains(int item) {
        return item >= lowerBound && item < upperBound;
    }

	
	
	
}
