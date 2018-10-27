package converter;
import javax.swing.*;

public class Main {	
	public static void main(String[] args) {
		// String num = JOptionPane.showInputDialog("Number?");
		String melike = "12.10";
		DoubleConverter a = new DoubleConverter(melike);
		String b = a.conversionToText();
		System.out.println();
		a.conversionBack(b);
	}	
}
