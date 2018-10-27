package converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class WordDictionary {
	public final Map<Integer, String> singleDigits = new HashMap<Integer, String>() {{
        put(9, "nine");
        put(8, "eight");
        put(7, "seven");
        put(6, "six");
        put(5, "five");
        put(4, "four");
        put(3, "three");
        put(2, "two");
        put(1, "one");
        put(0, "");
    }};
    public final Map<Integer, String> tenAndHundreds = new HashMap<Integer, String>() {{
        for (int integer : singleDigits.keySet()) {
            put(integer * 100, singleDigits.get(integer) + " hundred");
        }        
        put(90, "ninety");
        put(80, "eighty");
        put(70, "seventy");
        put(60, "sixty");
        put(50, "fifty");
        put(40, "forty");
        put(30, "thirty");
        put(20, "twenty");
        put(19, "nineteen");
        put(18, "eighteen");
        put(17, "seventeen");
        put(16, "sixteen");
        put(15, "fifteen");
        put(14, "fourteen");
        put(13, "thirteen");
        put(12, "twelve");
        put(11, "eleven");
        put(10, "ten");
        putAll(singleDigits);
        
    }};
    public final Map<Integer, String> between21and99 = new HashMap<Integer, String>() {{
        for (int i=21; i<100; i++) {
        		if(i%10!=0) { // if not put before
        			int ten=(i/10)*10;
        			int mod=i%10;
        			String word = tenAndHundreds.get(ten)+" "+singleDigits.get(mod);
        			put(i, word);
        		}
        }	    
	    putAll(tenAndHundreds);
    }};
    public final Map<Integer, String> fullDictionary = new HashMap<Integer, String>() {{
	    	for (int i=101; i<1000; i++) { // left numbers
	        	if(i%100!=0) { // if not put before
	    			int hundred=(i/100)*100;
	    			int mod=i%100;
	    			String word = tenAndHundreds.get(hundred)+" and "+between21and99.get(mod);
	    			put(i, word);
	    		}
	    }
	    putAll(between21and99);
    }};
    
    public <Integer, String> Integer getKeyByValue(Map<Integer, String> map, String value) {
    		// searching for number version of given text
		for(Entry<Integer, String> entry : map.entrySet()) {
			if(Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}			
		}
		return null;
	}    
    
}
