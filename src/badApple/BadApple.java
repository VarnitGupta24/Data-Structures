import java.time.Instant;
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
	public long FRAME = 1;
	public final int fps = 20;

	private String resDir = "res";
	private BufferedReader br;

	public BadApple(int canvasW, int canvasH) {
		cw = canvasW;
		ch = canvasH;
		br = readFile(resDir + "/badapple.dat");
	}

	public void nextFrame() throws IOException {
		// resets cursor position (or clear screen?)
		System.out.print("\033\143");

		for(int i = 0; i < ch; i++) {
			System.out.println(br.readLine());
		}
		System.out.println(FRAME);
		FRAME++;
	}

	public BufferedReader readFile(String path) {
		try {
			return new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
		return null;
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
			// start time
			long start = Instant.now().toEpochMilli();
			long timeElapsed = 0;
			for(;;) {
				try { 
					ba.nextFrame(); 
				} catch (IOException e) { System.err.println(e);}

				try {
					while (timeElapsed < 1000 / ba.fps * ba.FRAME) {
						// System.out.println(timeElapsed);
						// System.out.println(1000 / ba.fps * ba.FRAME);
						Thread.sleep(5);
						timeElapsed = (Instant.now().toEpochMilli() - start);
					}
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
