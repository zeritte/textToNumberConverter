package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import converter.DoubleConverter;
import converter.Splitter;

class testDoubleConverter {
	// these tests checks both conversion to text and conversion back!
	@Test
	void smallerThanThousand() {
		DoubleConverter tester = new DoubleConverter("545.40");
		assertEquals("five hundred and forty five dollar(s) forty cent(s)" , tester.conversionToText());
		assertEquals("545.40", tester.conversionBack(tester.conversionToText()));
	}
	
	@Test
	void smallerThanMillion() {
		DoubleConverter tester = new DoubleConverter("31200.21");
		assertEquals("thirty one thousand two hundred dollar(s) twenty one cent(s)" , tester.conversionToText());
		assertEquals("31200.21", tester.conversionBack(tester.conversionToText()));
	}
	
	@Test
	void largerThanMillion() {
		DoubleConverter tester = new DoubleConverter("12344321.34");
		assertEquals("twelve million three hundred and forty four thousand three hundred and twenty one dollar(s) thirty four cent(s)" , tester.conversionToText());
		assertEquals("12344321.34", tester.conversionBack(tester.conversionToText()));
	}
	
	@Test
	void withoutCents() {
		DoubleConverter tester = new DoubleConverter("233.00");
		assertEquals("two hundred and thirty three dollar(s)" , tester.conversionToText());
		assertEquals("233.00", tester.conversionBack(tester.conversionToText()));
	}
	
	@Test
	void withoutThousands() {
		DoubleConverter tester = new DoubleConverter("1000999.01");
		assertEquals("one million nine hundred and ninety nine dollar(s) one cent(s)" , tester.conversionToText());
		assertEquals("1000999.01", tester.conversionBack(tester.conversionToText()));
	}
	
	@Test
	void unnecessaryZerosAtTheBeginning() {
		DoubleConverter tester = new DoubleConverter("002.34");
		assertEquals("two dollar(s) thirty four cent(s)" , tester.conversionToText());
		assertEquals("2.34", tester.conversionBack(tester.conversionToText()));
	}
	
	
	
	

}
