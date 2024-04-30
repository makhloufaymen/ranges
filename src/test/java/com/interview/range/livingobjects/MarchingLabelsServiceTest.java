package com.interview.range.livingobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.interview.range.livingobjects.exception.LabelNotFoundException;
import com.interview.range.livingobjects.model.Label;
import com.interview.range.livingobjects.model.Range;
import com.interview.range.livingobjects.service.MarchingLabelsService;

/**
 * 
 */
@SpringBootTest
public class MarchingLabelsServiceTest {

	@Mock
	private List<Range> ranges;

	@InjectMocks
	private MarchingLabelsService marchingLabelsService;

    private Random random;

	
    @BeforeEach
    void setUp() {
    	random =  new Random();
    	Range rangeA = new Range("A", 0, 6);
        Range rangeB = new Range("B", 5, 7);
        List<Range> mockRanges = new ArrayList<>();
        mockRanges.add(rangeA);
        mockRanges.add(rangeB);
        
         marchingLabelsService = new MarchingLabelsService(mockRanges);
    }


	@Test
	void testMarchingLabels() throws LabelNotFoundException {

		// Test case 1
		Label[] labels1 = marchingLabelsService.marchingLabels(2);
		assertEquals(1, labels1.length);
		assertEquals("A", labels1[0].getLabel());

		// Test case 2
		Label[] labels2 = marchingLabelsService.marchingLabels(5);
		assertEquals(2, labels2.length);
		assertEquals("A", labels2[0].getLabel());
		assertEquals("B", labels2[1].getLabel());

		// Test case 3
		Label[] labels3 = marchingLabelsService.marchingLabels(6);
		assertEquals(1, labels3.length);
		assertEquals("B", labels3[0].getLabel());

		// Test case 4
		Label[] labels4 = marchingLabelsService.marchingLabels(8);
		assertEquals(0, labels4.length);
	}

	
	
	/** Test performance 
	 * @throws LabelNotFoundException
	 */
	@RepeatedTest(100)
	void testPerformanceMarchingLabels() throws LabelNotFoundException {
		int iterations = random.nextInt(1000000) + 1;
		long startTime = System.nanoTime();
		for (int i = 0; i < iterations; i++) {

			Label[] labels = marchingLabelsService.marchingLabels(2);
			assertEquals(1, labels.length);
			assertEquals("A", labels[0].getLabel());
		}
		long endTime = System.nanoTime();
		long durationMs = (endTime - startTime) / 1_000_000;
		System.out.println("Test duration for " + iterations + " iterations: " + durationMs + " ms");
	}
}
