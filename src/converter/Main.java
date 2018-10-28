package converter;
import javax.swing.*;

public class Main {	
	public static void main(String[] args) {
		// String num = JOptionPane.showInputDialog("Number?");
		String num = "1038.15";
		DoubleConverter a = new DoubleConverter(num);
		String b = a.conversionToText();
		System.out.println();
		a.conversionBack(b);
	}	
}
