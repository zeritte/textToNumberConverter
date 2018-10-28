package converter;

public class Main {	
	public static void main(String[] args) {
		String num = "1.00"; // it has to have exactly 2 decimal points and should be larger than 1
		DoubleConverter TOBERUN = new DoubleConverter(num);
		TOBERUN.run();
	}
}
