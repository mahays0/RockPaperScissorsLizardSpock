package com.example.util;

import java.io.Serializable;

public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3539711045998659730L;
	public String command;
	public Object[] args;
	public Message(String command, Object[] args){
		this.command=command;
		this.args=args;
	}
}
