package codeChef;


import java.util.Scanner;

public class ada_Bishop {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {

			int r = scn.nextInt();
			int c = scn.nextInt();

			int count = 16;
			int no = 0;
			
			
			if(r==1&&c==1) {
				
			System.out.println("16");
			
			System.out.println("8 8"
					+"\n"+ "7 7"
					+"\n"+ "6 8"
					+"\n"+ "1 3"
					+"\n"+ "3 1"
					+"\n"+ "8 6"
					+"\n"+ "7 5"
					+"\n"+ "8 4"
					+"\n"+ "5 1"
					+"\n"+ "1 5"
					+"\n"+ "4 8"
					+"\n"+ "3 7"
					+"\n"+ "2 8"
					+"\n"+ "8 2"
					+"\n"+ "7 1"
					+"\n"+ "1 7"
					);
			}
			else {
				int sum = r+c;
				no = sum/2;
				System.out.println("18");
				System.out.println(no+" "+no
						+ "\n" +"1 1"
						+ "\n" +"8 8"
						+"\n"+ "7 7"
						+"\n"+ "6 8"
						+"\n"+ "1 3"
						+"\n"+ "3 1"
						+"\n"+ "8 6"
						+"\n"+ "7 5"
						+"\n"+ "8 4"
						+"\n"+ "5 1"
						+"\n"+ "1 5"
						+"\n"+ "4 8"
						+"\n"+ "3 7"
						+"\n"+ "2 8"
						+"\n"+ "8 2"
						+"\n"+ "7 1"
						+"\n"+ "1 7"
						);
				
				
				
				
			}

			tc--;
		}

	}

}
