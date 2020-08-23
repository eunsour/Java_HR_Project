package Location;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.ImageIcon;

public class GoogleAPI {
	public void downloadMap(String location) {
		try {
				
			String imageURL = "https://maps.googleapis.com/maps/api/"
					+ "staticmap?key=AIzaSyBe7aZyK6eAUIV5sHf7b9StKpptszMLR0I&&markers=color:red%7Clabel:A%7C"
					+ "center=" + URLEncoder.encode(location, "UTF-8") + "&zoom=17&size=612x612&scale=2";
			URL url = new URL(imageURL);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(location);
			byte[] b = new byte[2048];
			int length;
			while((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
			is.close();
			os.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ImageIcon getMap(String location) {
		return new ImageIcon((new ImageIcon(location)).getImage().getScaledInstance(612, 612, java.awt.Image.SCALE_SMOOTH));
	}
	
	public void FileDelete(String fileName) {
		File f = new File(fileName);
		f.delete();
	}
}
