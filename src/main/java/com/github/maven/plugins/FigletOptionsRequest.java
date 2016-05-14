package com.github.maven.plugins;

import java.io.OutputStream;

public class FigletOptionsRequest extends FigletRequest {
	String font;
	String text = "building it>>";
	Driver<?> driver;
	
	OutputStream out = System.out;

	public FigletOptionsRequest(Driver<FigletOptionsRequest> fig, String string) {
		this.driver = fig;
		this.text = string;
	}

	public FigletOptionsRequest() {
	}

	public FigletOptionsRequest text(String string) {
		if(string != null) {
			this.text = string;
		}
		return this;
	}

	public FigletOptionsRequest out(OutputStream out) {
		this.out = out;
		return this;
	}
	
	public FigletOptionsRequest driver(Driver<?> fig) {
		this.driver = fig;
		return this;
	}

	public FigletOptionsRequest font(String filename) {
		this.font = filename;
		return this;
	}

}