import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ImageToByteArray {
	
	public static void main(String[] args) {
		try {
			File file = new File("icon.png");
			BufferedImage im = ImageIO.read(file);
			ByteArrayOutputStream bas = new ByteArrayOutputStream();
			ImageIO.write(im,"png",bas);
			byte[] data = bas.toByteArray();
			System.out.println(Arrays.toString(data));

			Scanner scan = new Scanner(System.in);
			scan.next();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
