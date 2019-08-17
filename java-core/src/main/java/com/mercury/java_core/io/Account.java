package com.mercury.java_core.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Account implements Externalizable {
	
	String username;
	String password;
	
	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + "]";
	}
	
	// Externalizable: need public empty constructor
	public Account() {
		
	}

	Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(username);
		out.writeObject(password);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		username = (String)in.readObject();
		if (Math.random() > 0.5) { // go DB to check if user is admin or not
			password = (String)in.readObject();
		}
	}
	
}
