package de.BentiGorlich.BatrikaBasic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Calendar;
import java.util.Random;

import javax.imageio.ImageIO;

import org.json.JSONObject;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Helper {
	public static String JsonToString(JSONObject json) {
		String erg = json.toString();
		erg = erg.replace("{", "{\n");
		erg = erg.replace("}", "\n}");
		
		erg = erg.replace("[", "[\n");
		erg = erg.replace("]", "\n]");
		
		erg = erg.replace(",", ",\n");
		return erg;
	}
	public static String getFileChecksum(MessageDigest digest, File file) throws IOException{
	    //Get file input stream for reading the file content
		if(!file.exists()) {
			return "";
		}
	    FileInputStream fis = new FileInputStream(file);
	    //Create byte array to read data in chunks
	    byte[] byteArray = new byte[1024];
	    int bytesCount = 0; 
	    //Read file data and update in message digest
	    while ((bytesCount = fis.read(byteArray)) != -1) {
	        digest.update(byteArray, 0, bytesCount);
	    };
	    //close the stream; We don't need it now.
	    fis.close();
	    //Get the hash's bytes
	    byte[] bytes = digest.digest();
	    //This bytes[] has bytes in decimal format;
	    //Convert it to hexadecimal format
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i< bytes.length ;i++){
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    //return complete hash
	   return sb.toString();
	}
	private static Image Base64ToImage(String imagedata) {
		if(!imagedata.equals("")) {
			byte[] base = Base64.getDecoder().decode(imagedata);
			Image erg = new Image(new ByteArrayInputStream(base), 500, 500, true, true);
			return erg;
		}
		return null;
	}

	private static String ImageToBase64(Image profile_picture) {
		if(profile_picture != null){
			try {
				BufferedImage bImage = SwingFXUtils.fromFXImage(profile_picture, null);
				ByteArrayOutputStream s = new ByteArrayOutputStream();
				ImageIO.write(bImage, "png", s);
				byte[] res  = s.toByteArray();
				s.close(); 
				String erg = Base64.getEncoder().encodeToString(res);
				return erg;
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public static String SHA256(String toHash) {
		try{ 
			MessageDigest dig = MessageDigest.getInstance("SHA-256");
			byte[] hash = dig.digest(toHash.getBytes("UTF-8"));
			String encoded = Base64.getEncoder().encodeToString(hash);
			return encoded;
		} catch(Exception e) {
			return null;
		}
	}
	public static String getTime(Calendar time) {
		Calendar now = Calendar.getInstance();
		String hour, min, day, month, year;
		if(time.get(Calendar.HOUR_OF_DAY)<10) {
			hour = "0" + time.get(Calendar.HOUR_OF_DAY);
		}else {
			hour = "" + time.get(Calendar.HOUR_OF_DAY);
		}
		if(time.get(Calendar.MINUTE)<10) {
			min = "0" + time.get(Calendar.MINUTE);
		}else{
			min = "" + time.get(Calendar.MINUTE);
		}
		day = "" + time.get(Calendar.DAY_OF_MONTH);
		month = "" + (time.get(Calendar.MONTH) + 1);
		year = "" + time.get(Calendar.YEAR);
		if(	time.get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH)
				&& time.get(Calendar.MONTH) == now.get(Calendar.MONTH)
				&& time.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
			
			return hour + ":" + min;
			
		}else if(time.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
			return day + "." + month + " " + hour + ":" + min;
		}else {
			return hour + ":" + min + " " + day + "." + month + "." + year;
		}
	}

	public static void deleteDirectory(File serverDir) {
		if(serverDir.exists()) {
			if(serverDir.isDirectory()) {
				File[] files = serverDir.listFiles();
				if(files.length == 0) {
					serverDir.delete();
				}else {
					for(int i = 0; i<files.length; i++) {
						File curr = files[i];
						if(curr.isFile()) {
							curr.delete();
						}else {
							deleteDirectory(curr);
						}
					}
					serverDir.delete();
				}
			}else {
				serverDir.delete();
			}
		}
	}
	public static Paint randomColor() {
		Random r = new Random();
		return Color.color(r.nextDouble(), r.nextDouble(), r.nextDouble());
	}
}
