package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import converter.WordDictionary;

class testDictionary {

	@Test
	void testToFindWord() {
		WordDictionary dict = new WordDictionary();
		assertEquals("one",dict.fullDictionary.get(1));
	}
	
	@Test
	void testToFindNum() {
		WordDictionary dict = new WordDictionary();
		assertSame(123,dict.getKeyByValue(dict.fullDictionary, "one hundred and twenty three"));
	}
	
	@Test
	void testNotToFindNum() {
		WordDictionary dict = new WordDictionary();
		assertNull(dict.getKeyByValue(dict.fullDictionary, "one thousand and one hundred and ninety three"));
	}

}
