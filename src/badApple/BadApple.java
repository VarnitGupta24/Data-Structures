import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class BadApple {
	private int cw;
	private int ch;
	private long FRAME = 0;

	private String srcDir = "res";
	private BufferedReader br;

	public BadApple(int canvasW, int canvasH) {
		cw = canvasW;
		ch = canvasH;
		readFrames();
	}

	public void nextFrame() throws IOException {
		// char escCode = 0x1B;
		// int row = 10; int column = 10;
		// System.out.print(String.format("%c[%d;%df",escCode,row,column));
		// System.out.print("\033[H\033[2J");
	    	// System.out.flush();
		System.out.print("\033\143");

		for(int i = 0; i < ch; i++) {
			System.out.println(br.readLine());
		}
		System.out.println(FRAME);
		FRAME++;
	}

	public void readFrames() {
		try {
			br = new BufferedReader(new FileReader(srcDir + "/badapple.dat"));
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
	}

	// private void buildFrames(int w, int h) {
	// 	File in = new File(srcDir + "badapple.mp4");
	// 	FileWriter out = new FileWriter(srcDir + "badapple.dat");
	// 	out.write("");
	// 	// TODO: finish this
	// }

	public static void main(String[] args) {
		BadApple ba = new BadApple(80, 40);

		new Thread(() -> {
			for(;;) {
				try { ba.nextFrame(); }
				catch (IOException e) { System.err.println(e);}
				// System.out.println("fuckyou");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					System.err.println(e);
				}
			}
		}).start();

		Scanner stdin = new Scanner(System.in);

		for(;;) {
			while (stdin.nextLine().equals("q")) {
				System.out.println("finished");
				return;
			}
		}


	}
}
