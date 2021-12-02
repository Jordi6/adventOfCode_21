
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

	int horizontal = 0;
	int depth = 0;
	int aim = 0;

	// String[] data = {
	//    "forward 5",
	//    "down 5",
	//    "forward 8",
	//    "up 3",
	//    "down 8",
	//    "forward 2"
	// };


	for (String v: data) {

		String[] pos = v.split(" ");
		String command = pos[0];
		int amount = Integer.parseInt(pos[1]);

		switch(command) {
			case "forward":
			horizontal += amount;
			depth += aim * amount;
			break;

			case "down":
			aim += amount;
			break;

			case "up":
			aim -= amount;
			break;
		}
	}

	int result = horizontal * depth;
	System.out.println("result: " + result);

	}
}


