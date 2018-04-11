package de.BentiGorlich.BatrikaBasic;

public enum Visibility {
	everyone(0),
	FriendsOfFriends(1),
	Friends(2)
	;
	int i;
	Visibility(int i){
		this.i = i;
	}
	public int toInt() {
		return i;
	}
	public static Visibility fromInt(int i ) {
		switch (i) {
		case 0: return Visibility.everyone;
		case 1: return Visibility.FriendsOfFriends;
		case 2: return Visibility.Friends;
		default: return Visibility.everyone;
		}
	}
}
