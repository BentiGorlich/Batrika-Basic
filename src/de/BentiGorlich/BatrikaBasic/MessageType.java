package de.BentiGorlich.BatrikaBasic;


public enum MessageType {
	message(0),
	message_received(1),
	message_received_user(2),
	message_fail(36), 
	message_seen(41),
	
	login(3),
	login_fail(4),
	selfinfo(38),
	
	room_join(5),
	room_join_fail(6),
	
	group_join(7),
	group_join_fail(8),
	
	user_block(31),
	user_block_fail(32),
	user_unblock(33),
	user_unblock_fail(34),
	user_search(40),
	user_info(35),
	user_create(9),
	user_create_fail(10),
	user_change(11),
	user_change_fail(12),
	user_delete(13),
	user_delete_fail(14),
	
	room_info(42),
	room_search(43),
	room_create(15),
	room_create_fail(16),
	room_change(17),
	room_change_fail(18),
	room_delete(19),
	room_delete_fail(20),
	
	create_group(21),
	create_group_fail(22),
	group_change(23),
	group_change_fail(24),
	group_delete(25),
	group_delete_fail(26),
	
	contact_add(27),
	contact_add_fail(28),
	contact_remove(29),
	contact_remove_fail(30),
	
	media(37),
	profile_picture(39),
	;
	int num;
	MessageType(int num){
		this.num = num;
	}
	public int toInt(){
		return num;
	}
	public static MessageType get(int i) {
		switch(i) {
		case 0: return message;
		case 1: return message_received;
		case 2: return message_received_user;
		case 3: return login;
		case 4: return login_fail;
		case 5: return room_join;
		case 6: return room_join_fail;
		case 7: return group_join;
		case 8: return group_join_fail;
		case 9: return user_create;
		case 10: return user_create_fail;
		case 11: return user_change;
		case 12: return user_change_fail;
		case 13: return user_delete;
		case 14: return user_delete_fail;
		case 15: return room_create;
		case 16: return room_create_fail;
		case 17: return room_change;
		case 18: return room_change_fail;
		case 19: return room_delete;
		case 20: return room_delete_fail;
		case 21: return create_group;
		case 22: return create_group_fail;
		case 23: return group_change;
		case 24: return group_change_fail;
		case 25: return group_delete;
		case 26: return group_delete_fail;
		case 27: return contact_add;
		case 28: return contact_add_fail;
		case 29: return contact_remove;
		case 30: return contact_remove_fail;
		case 31: return user_block;
		case 32: return user_block_fail;
		case 33: return user_unblock;
		case 34: return user_unblock_fail;
		case 35: return user_info;
		case 36: return message_fail;
		case 37: return media;
		case 38: return selfinfo;
		case 39: return profile_picture;
		case 40: return user_search;
		case 41: return message_seen;
		case 42: return room_info;
		case 43: return room_search;
		default: return message;
		}
	}
}
