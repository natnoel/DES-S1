/**
 * Tan Shi Terng Leon
 * 4000602
 * S1.java
 */

/**
 * @author Leon
 *
 */
import java.util.Scanner;


public class S1 {

	/**
	 * @param args
	 */
	
	//S1 S-box
	static int sbox[][] =
		{
			{14,	4,	13,	1,	2,	15,	11,	8,	3,	10,	6,	12,	5,	9,	0,	7},
			{0,	15,	7,	4,	14,	2,	13,	1,	10,	6,	12,	11,	9,	5,	3,	8},
			{4,	1,	14,	8,	13,	6,	2,	11,	15,	12,	9,	7,	3,	10,	5,	0},
			{15,	12,	8,	2,	4,	9,	1,	7,	5,	11,	3,	14,	10,	0,	6,	1}
		};
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, row, col;
		
		boolean validInput;
		do {
			validInput = true;
			System.out.print("Enter your input: ");
			if (!scn.hasNextInt())
				validInput = false;
			n = scn.nextInt();
			if (n < 0 || n > 63)
				validInput = false;
			if (validInput == false) {
				System.out.println("Please enter a 6 bit integer. (between 0 and 63 inclusive)");
			}
		}while (validInput == false);
			
		col = n;
		row = 0;
		if (n >= 32) {	//If leftmost bit is set
			row += 2;	//Adds 2 to the decimal value of the row
						//(since leftmost bit of the row in the s-box is set)
			col -= 32;	//Remove the leftmost bit (if it is set)
		}
		if (n % 2 == 1)	//If rightmost bit is set
			row += 1;	//Adds 1 to the decimal value of the row
						//(since the rightmost bit of the row in the s-box is set)
		
		col = col >> 1;	//Remove the rightmost bit of the column
			
		System.out.println(
				"Output of S1 is:\n" +
				"Decimal: " + sbox[row][col] + "\n" +
				"Binary: [" + binaryFormat(sbox[row][col]) + "]\n");
			
		scn.close();
	}
	
	static String binaryFormat(int value) {
		StringBuffer sb = new StringBuffer(Integer.toBinaryString(value));	//Converts from decimal to binary
		
		while (sb.length() < 4)	//Padding zeros to the front if needed
			sb.insert(0, '0');
		
		return sb.toString().replaceAll(".(?!$)", "$0 ");	//Insert spacing
	}
}
