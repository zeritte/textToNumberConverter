package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import converter.DoubleConverter;

class testMain {

	@Test
	void AccuracyTest() {
		int one = (int) (Math.random() * (999999999 - 1)) + 1;
		int two = (int) (Math.random() * (99-1)) + 1;
		String num = Integer.toString(one)+"."+Integer.toString(two);
		DoubleConverter runner = new DoubleConverter(num);
		assertEquals(num,runner.conversionBack(runner.conversionToText()));
	}

}
