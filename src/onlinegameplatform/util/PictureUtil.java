package onlinegameplatform.util;

import javax.swing.*;

public class PictureUtil {


	public static ImageIcon getPictureBird(String name) {
		ImageIcon icon = new ImageIcon(PictureUtil.class.getResource("/onlinegameplatform/resource/image/imagebird/" + name));
		return icon;
	}

	public static ImageIcon getPictureGobang(String name) {
		ImageIcon icon = new ImageIcon(PictureUtil.class.getResource("/onlinegameplatform/resource/image/imagegobang/" + name));
		return icon;
	}

	public static ImageIcon getPictureAirwar(String name) {
		ImageIcon icon = new ImageIcon(PictureUtil.class.getResource("/onlinegameplatform/resource/image/imageairwar/" + name));
		return icon;
	}

}
