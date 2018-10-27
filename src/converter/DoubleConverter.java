package converter;

public class DoubleConverter {
	int firstThree, secondThree, thirdThree;
	String strVersion= "";
	Splitter done;
	String convertedBack;
	WordDictionary dict = new WordDictionary();
	
	DoubleConverter(String item) { // constructor
		this.done = new Splitter(item);
	}
	
	public String conversionToText() {
		try {
			switch(done.nullElement) { // using splitted array and dictionary I created, conversion is done
			case 0: // smaller than 1000
				firstThree=Integer.parseInt(done.splitted[0]);
				strVersion = dict.fullDictionary.get(firstThree);
				break;
			case 1: // between 1000-1000000
				firstThree=Integer.parseInt(done.splitted[0]);
				secondThree=Integer.parseInt(done.splitted[1]);
				strVersion = dict.fullDictionary.get(firstThree)+" thousand "+dict.fullDictionary.get(secondThree);
				break;
			case 2: // between 1000000-999999999
				firstThree=Integer.parseInt(done.splitted[0]);
				secondThree=Integer.parseInt(done.splitted[1]);
				thirdThree=Integer.parseInt(done.splitted[2]);
				if(secondThree!=0) { // if it has thousands
					strVersion = dict.fullDictionary.get(firstThree)+" million "+dict.fullDictionary.get(secondThree)+" thousand "+dict.fullDictionary.get(thirdThree);
				} else { // if it is something like 1000999
					strVersion = dict.fullDictionary.get(firstThree)+" million "+dict.fullDictionary.get(thirdThree);
				}				
				break;
			}
			String decimalPart = dict.fullDictionary.get(Integer.parseInt(done.decimal));
			if(decimalPart=="") { // does it have cents or not?
				strVersion=strVersion+" dollar(s)";
			}else {
				strVersion=strVersion+" dollar(s) "+decimalPart+" cent(s)";
			}			
			System.out.print(strVersion);
			return strVersion;
		} 
		catch(Exception e) {
			throw new IllegalArgumentException("Error, maybe too big number or not a number");
		}
	}
	
	
	public String conversionBack(String strVersion) {
		int converted=0, i=0, num;
		String decimalPart="";
		this.done = new Splitter(strVersion); // reconstruction with strVersion of num
		while(i!=3) {
			num=dict.getKeyByValue(dict.fullDictionary, done.splitted[i]); // number version of splitted text
			switch(i) { // cases are multiplied with necessary coefficients.
			case 2:
				converted = converted + num;
				break;
			case 1:
				converted = converted + 1000*num;
				break;
			case 0:
				converted = converted + 1000000*num;
				break;
			}
			i++;
		}
		convertedBack = Integer.toString(converted);		
		if(dict.getKeyByValue(dict.fullDictionary, done.decimal) < 10) { // if it has less then ten cents, we need to make an arrangement
			decimalPart = "0"+Integer.toString(dict.getKeyByValue(dict.fullDictionary, done.decimal));
		}else {
			decimalPart = Integer.toString(dict.getKeyByValue(dict.fullDictionary, done.decimal));
		}
		convertedBack = convertedBack + "." + decimalPart;
		System.out.println(convertedBack);
		return convertedBack;
	}
}
