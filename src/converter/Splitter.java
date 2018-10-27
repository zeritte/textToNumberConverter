package converter;

public class Splitter {
	String input, decimal;
	String[] splitted;
	int mod, quotient, nullElement;
	boolean isNum=true;	
	
	Splitter(String input_){ // constructor
		this.splitted = new String[3]; // cleaning this up!
		if(Character.isDigit(input_.charAt(0))) { // if it is a number
			int q=0;
			while(true) {
				char checker = input_.charAt(q);
				if(checker=='.'){ // checks for decimals
					break;
				}
				q++;
			}
			this.input=input_.substring(0,q);
			this.decimal = input_.substring(q+1);
		} else { // if it is a text to be converted to number
			// decimal part is seperated and held in another string
			int lengthOfDollar=" dollar(s)".length();
			int dollarIndex= input_.indexOf("dollar");
			int centIndex=input_.indexOf(" cent");
			this.input=input_.substring(0, dollarIndex-1);
			this.decimal=input_.substring(dollarIndex+lengthOfDollar, centIndex);
			isNum=false;
		}
		Split();
	}
	
	
	public void Split() {
		if(isNum) {
			mod=input.length()%3;
			quotient=input.length()/3;
			splitNum();
			numChecker();
		} else {
			splitText();
		}
	}
	
	public void splitText() {
		int lengthOfThousand = " thousand".length();
		int lengthOfMillion = " million".length();
		int thousandIndex = input.indexOf("thousand");
		int millionIndex = input.indexOf("million");
		if(thousandIndex!=-1 && millionIndex !=-1) {
			// if it contains both the word thousand and the word million
			splitted[0]=input.substring(0, millionIndex-1);
			splitted[1]=input.substring(millionIndex+lengthOfMillion, thousandIndex-1);
			splitted[2]=input.substring(thousandIndex+lengthOfThousand);
		}else if (thousandIndex!=-1 && millionIndex==-1) {
			// if it contains only the word thousand
			splitted[0]="";
			splitted[1]=input.substring(0, thousandIndex-1);
			splitted[2]=input.substring(thousandIndex+lengthOfThousand);
		}else if (thousandIndex==-1 && millionIndex!=-1) {
			// if it contains only the word million
			splitted[0]=input.substring(0, millionIndex-1);
			splitted[1]="";
			splitted[2]=input.substring(millionIndex+lengthOfMillion);
		}else if(thousandIndex==-1 && millionIndex==-1) {
			// if it does not contain both the word thousand and the word million
			splitted[0]="";
			splitted[1]="";
			splitted[2]=input;
		}
	}
	
	
	public void splitNum() {
		switch(quotient) { // splitting to 3-num digits
		case 0:
			splitted[0]=input;
			break;
		case 1:
			if(mod==0) {
				splitted[0]=input.substring(0, 3);
			} else {
				splitted[0]=input.substring(0, mod);
				splitted[1]=input.substring(mod, mod+3);
			}			
			break;
		case 2:
			if(mod==0) {
				splitted[0]=input.substring(0, 3);
				splitted[1]=input.substring(3, 6);
			}else {
				splitted[0]=input.substring(0, mod);
				splitted[1]=input.substring(mod, mod+3);
				splitted[2]=input.substring(mod+3, mod+6);
			}			
			break;
		case 3:
			splitted[0]=input.substring(0, 3);
			splitted[1]=input.substring(3, 6);
			splitted[2]=input.substring(6);
			break;
		}
	}
	
	public void numChecker(){ // searches for number of digits so that we will know where to work
		nullElement=2;
		if(splitted[nullElement]!=null) { // it is a number with more than 6 digits
			nullElement=2;
		}
		while(splitted[nullElement]==null) { // it has maximum 6 digits
			nullElement--;
		}
	}
	
}
