package de.BentiGorlich.BatrikaBasic;

import java.util.ArrayList;

import org.json.JSONArray;

@SuppressWarnings("serial")
public class MediaFragmented extends ArrayList<JSONArray>{
	boolean isComplete = false;
	boolean isInitialized = false;
	public int ID;
	public String name;
	public String Filename;
	
	public long totalSize;
	public long currentSize = 0;
	
	public MediaFragmented(long totalSize) {
		super();
		this.totalSize = totalSize;
	}
	
	@Override
	public boolean add(JSONArray a) {
		currentSize += a.length();
		return super.add(a);
	}
	
	public void setCompleted(boolean value) {
		isComplete = value;
	}
	
	public void setInitialized(boolean value) {
		isInitialized = value;
	}
	
	public boolean isComplete() {
		return isComplete;
	}
	
	public boolean isInitialized() {
		return isInitialized;
	}
}
