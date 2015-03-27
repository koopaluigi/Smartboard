package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.YCPCS.Whiteboard.Model.*;
import com.YCPCS.Whiteboard.Model.Class;

public class InitialData {
	
	public static List<User> getUsers() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("Users.csv");
		try {
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User();
				user.setUsername(i.next());
				user.setPassword(i.next());
				user.setLastname(i.next());
				user.setFirstname(i.next());
				// add whiteboard permissions
				// add login date
				userList.add(user);
			}
			return userList;
		} finally {
			readUsers.close();
		}
	}

	public static List<Class> getClasses() throws IOException {
		List<Class> classList = new ArrayList<Class>();
		ReadCSV readClasses = new ReadCSV("Classes.csv");
		try {
			while (true) {
				List<String> tuple = readClasses.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Class class1 = new Class();
				class1.setClassSize(Integer.parseInt(i.next()));
				
				// add whiteboard permissions
				// add login date
				classList.add(class1);
			}
			return classList;
		} finally {
			readClasses.close();
		}
	}
	
	
}
