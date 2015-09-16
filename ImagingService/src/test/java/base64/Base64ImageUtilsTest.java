package base64;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.junit.Test;

import base64.Base64ImageUtils;

public class Base64ImageUtilsTest {

	Logger logger = Logger.getLogger(this.getClass().getName());
			
	@Test
	public void testBase64EncodingDecoding() throws IOException {
		BufferedImage img = ImageIO.read(new File("./src/test/resources/Img.jpg"));
		BufferedImage scaledImg = Base64ImageUtils.scale(img, 50, 50);
		BufferedImage newImg;
		String imgstr;
		imgstr = Base64ImageUtils.encodeToString(scaledImg, "jpg");
		logger.log(Level.INFO, imgstr);
		newImg = Base64ImageUtils.decodeToImage(imgstr);
		ImageIO.write(newImg, "jpg", new File("./src/test/resources/CopyOfImg.jpg"));
	}

}

