package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import converter.Splitter;

class testSplitter {

	@Test
	void SplitterWith3Digits() {
		String myString = "123.34";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(split.getSplitted()[i]!=null) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("123", splitted);
		assertEquals("34", split.getDecimal());
		assertEquals(0, split.getNullElement());
	}
	@Test
	void SplitterWithOneDigit() {
		String myString = "1.99";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(split.getSplitted()[i]!=null) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("1", splitted);
		assertEquals("99", split.getDecimal());
		assertEquals(0, split.getNullElement());
	}
	@Test
	void SplitterWith4Digits() {
		String myString = "1043.00";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(split.getSplitted()[i]!=null) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("1043", splitted);
		assertEquals("00", split.getDecimal());
		assertEquals(1, split.getNullElement());
	}
	@Test
	void SplitterWith6Digits() {
		String myString = "222222.11";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(i!=3 && split.getSplitted()[i]!=null) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("222222", splitted);
		assertEquals("11", split.getDecimal());
		assertEquals(1, split.getNullElement());
	}
	@Test
	void SplitterWith7Digits() {
		String myString = "9999999.99";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(i!=3 && split.getSplitted()[i]!=null) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("9999999", splitted);
		assertEquals("99", split.getDecimal());
		assertEquals(2, split.getNullElement());
	}
	@Test
	void SplitterWith9Digits() {
		String myString = "123456789.56";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(i!=3 && split.getSplitted()[i]!=null) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("123456789", splitted);
		assertEquals("56", split.getDecimal());
		assertEquals(2, split.getNullElement());
	}	
	@Test
	void SplitterNotContainsMillionAndThousand() {
		String myString = "one hundred and thirty five dollar(s) thirty two cent(s)";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(i!=3) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("one hundred and thirty five", splitted);
		assertEquals("thirty two", split.getDecimal());
	}
	@Test
	void SplitterContainsMillionNotThousand() {
		String myString = "two million one hundred and thirty five dollar(s) thirty two cent(s)";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(i!=3) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("twoone hundred and thirty five", splitted);
		assertEquals("thirty two", split.getDecimal());
	}
	@Test
	void SplitterContainsThousandNotMillion() {
		String myString = "five hundred and seven thousand one hundred and thirty five dollar(s) thirty two cent(s)";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(i!=3) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("five hundred and sevenone hundred and thirty five", splitted);
		assertEquals("thirty two", split.getDecimal());
	}
	@Test
	void SplitterContainsMillionAndThousand() {
		String myString = "seven million nineteen thousand one hundred and thirty five dollar(s) thirty two cent(s)";
		Splitter split = new Splitter(myString);	
		String splitted = "";
		int i=0;
		while(i!=3) {
			splitted+=split.getSplitted()[i];
			i++;
		}
		assertEquals("sevennineteenone hundred and thirty five", splitted);
		assertEquals("thirty two", split.getDecimal());
	}

}
