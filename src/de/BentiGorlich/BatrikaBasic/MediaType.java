package de.BentiGorlich.BatrikaBasic;

public enum MediaType {
	profile_picture(0),
	picture(1),
	video(2);
	int i;
	MediaType(int i){
		this.i = i;
	}
	public static MediaType getFromInt(int i) {
		switch(i) {
		case 0: return profile_picture;
		case 1: return picture;
		case 2: return video;
		default: return profile_picture;
		}
	}
	public int toInt() {
		return i;
	}
}
