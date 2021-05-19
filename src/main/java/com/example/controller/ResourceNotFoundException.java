package com.example.controller;

public class ResourceNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5416815370594012309L;

	public ResourceNotFoundException (String message) {
		super(message);
	}
}
