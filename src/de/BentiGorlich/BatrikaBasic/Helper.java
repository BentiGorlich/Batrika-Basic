package de.BentiGorlich.BatrikaBasic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Random;

import com.google.gson.JsonObject;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Helper {
	public static String JsonToString(JsonObject json) {
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
	
	public static String SHA256(String toHash) {
		try{ 
			MessageDigest dig = MessageDigest.getInstance("SHA-256");
			byte[] hash = dig.digest(toHash.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for (byte b : hash) {
				sb.append(String.format("%02X ", b));
			}
			return sb.toString();
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
