
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class Solution {
	public static void main(String args[]) throws IOException {
	
	    ArrayList<String> data = readFile();
	    calc(data);
	}

	public static ArrayList<String> readFile() throws IOException {
	
	    File file = new File("input.txt");
	    Scanner myReader = new Scanner(file);
	    ArrayList<String> data = new ArrayList<String>();
	
	    while (myReader.hasNextLine()) {
	    	
	        data.add(myReader.nextLine());
	    }
	    myReader.close();
	    return data;
	}


	public static void calc(ArrayList<String> data) {

		int zeros = 0;
		int ones = 0;

		String val = "";

		for (int k = 0; k < data.get(0).length(); k++) {
			for (int j = 0; j < data.size(); j++) {

				if (data.get(j).charAt(k) == '0') {
					ones ++;
				} 
				else if (data.get(j).charAt(k) == '1') {
					zeros++;
				}
			}

			if (zeros > ones) {
				val += "0";
			}
			else {
				val += "1";
			}
			zeros = 0;
			ones = 0;
		}
		
		String[] str = val.split("");

		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("0")) {
				str[i] = "1";
			}
			else if (str[i].equals("1")) {
				str[i] = "0";	
			}
		}
		String s = String.join("", str);
		

		int g = Integer.parseInt(val, 2);
		int e = Integer.parseInt(s, 2);
		System.out.println(g * e);


	}

}






