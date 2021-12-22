
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Solution {

	public static ArrayList<String[]> data = new ArrayList<String[]>();
	public static ArrayList<Integer> nums_drawn = new ArrayList<Integer>();
	public static ArrayList<int[][]> boards = new ArrayList<int[][]>();

	public static void main(String args[]) throws IOException {

		readFile();
		partOne();
	}

	public static ArrayList<String[]> readFile() throws IOException {

		File file = new File("input.txt");
		Scanner myReader = new Scanner(file);
		ArrayList<Integer> board_nums = new ArrayList<Integer>();

		// read input and store data
		while (myReader.hasNextLine()) {
			String[] s = myReader.nextLine().split(",");
			data.add(s);
		}
		myReader.close();

		// rand nums drawn
		for (int i = 0; i < data.get(0).length; i++) {
			int values = Integer.parseInt(data.get(0)[i]);
			nums_drawn.add(values);
		}
		data.remove(0);

		// get rid of empty arrays in arrayList
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < data.get(i).length; j++) {
				if (data.get(i)[0].isEmpty())
					data.remove(i);

				if (!data.get(i)[j].isEmpty()) {

					String s = data.get(i)[j];
					Scanner scanner = new Scanner(s);
					while (scanner.hasNextInt()) {
						board_nums.add(scanner.nextInt());
					}
				}
			}
		}

		// fill the boards and add to array list of boards
		int count = 0;
		while (board_nums.size() > count) {

			int[][] card = new int[5][5];

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					card[i][j] = board_nums.get(count);
					count++;
				}
			}
			boards.add(card);
		}

		return data;
	}

	public static void partOne() {

		long answer = 0;
		for (Integer num : nums_drawn) {

			markBoards(boards, num);

			// check winning board
			boolean done = false;
			for (int[][] board : boards) {

				if (isBoardWon(board)) {

					long leftOver = calcLeftOver(board);
					answer = (leftOver * num);
					done = true;
					break;
				}
			}
			if (done)
				break;
		}
		System.out.println(answer);

	}

	private static long calcLeftOver(int[][] board) {

		long leftOver = 0;
		for (int[] row : board)
			for (int col : row)
				if (col != -1)
					leftOver += col;
		return leftOver;
	}

	public static void markBoards(ArrayList<int[][]> boards, int num) {

		for (int[][] board : boards) {
			for (int row = 0; row < board.length; row++)
				for (int col = 0; col < board[row].length; col++) {
					if (board[row][col] == num)
						board[row][col] = -1;
				}
		}
	}

	// Check winning board
	public static boolean isBoardWon(int[][] board) {

		boolean won;
		for (int row = 0; row < 5; row++) {
			won = true;
			for (int col = 0; col < 5; col++) {
				if (board[row][col] != -1) {
					won = false;
					break;
				}
			}
			if (won)
				return true;
		}

		for (int col = 0; col < 5; col++) {
			won = true;
			for (int row = 0; row < 5; row++) {
				if (board[row][col] != -1) {
					won = false;
					break;
				}
			}
			if (won)
				return true;
		}
		return false;

	}

}
