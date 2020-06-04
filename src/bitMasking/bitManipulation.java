package bitMasking;

public class bitManipulation {

	public static void main(String[] args) {

		extractBit(22, 5);

	}

	public static int extractBit(int n, int i) {

		int mask = 1;
		mask = 1 << (i - 1);
		n = n & mask;

		return (n == 0 ? 0 : 1);

	}

	public static int setBit(int n, int i) {

		int mask = 1;
		mask = 1 << (i - 1);
		n = n | mask;
		return n;

	}

	public static int resetBit(int n, int i) {

		int mask = 1;
		mask = ~(1 << (i - 1));
		n = n & mask;
		return n;

	}

	public static int rightMostSetBit(int n) {
		
		int pos = 1;
		int mask = 1;

		while ((n & mask) == 0) {

			pos++;
			mask = mask << 1;
		}

		return pos;
	}

}
