/*
 * Copyright (c) 2012, d10n
 * Distributed under the Simplified BSD License
 */
package com.bitinvert.reference;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile read and write encapsulation
 *
 * @author bitinvert.com / d10n
 */
public class RAF {
	char nullChar = '\u0000';
	private File file;

	public static void main(String[] args) {
		// Open or create hello.dat
		RAF raf = new RAF(new File("hello.dat"));

		String output[] = {"Hi", "there"};

		/* Put "Hi" into file, allocate 4 chars for the string, and begin
		 * placing the string 0 chars from the beginning of the file. */
		raf.setHelper(output[0], 4, 0L);

		/* Put "there" into file, allocate 4 chars for the string, and begin
		 * placing the string 4 chars from the beginning of the file. */
		raf.setHelper(output[1], 4, 4L);

		/* Get 4 chars from file, starting 0 chars from the beginning. */
		System.out.println(raf.getHelper(4, 0L));

		/* Get 4 chars from file, starting 4 chars from the beginning. */
		System.out.println(raf.getHelper(4, 4L));
	}

	private RAF(File file) {
		this.file = file;
	}

	/**
	 * Puts a string into a {@link RandomAccessFile}
	 *
	 * @param text
	 * 		The text to be inserted to the file
	 * @param rafAllocationLength
	 * 		The number of chars to allocate for storage
	 * @param rafPosition
	 * 		The number of chars to seek to from the beginning of {@code file}.
	 */
	public void setHelper(String text, int rafAllocationLength,
						  long rafPosition) {
		try {
			RandomAccessFile raf = new RandomAccessFile(this.file, "rw");
			try {
				rafPosition = rafPosition * 2;
				raf.seek(rafPosition);
				while(text.length() < rafAllocationLength) {
					text = text + nullChar;
				}
				raf.writeChars(text);
			} finally {
				raf.close();
			}
		} catch(IOException e) {
			System.out.println("IOException: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * Reads a String from a {@link RandomAccessFile}
	 *
	 * @param readLength
	 * 		Number of chars to read
	 * @param rafPosition
	 * 		Number of chars to skip from beginning of {@code file}
	 * @return the string
	 */
	public String getHelper(int readLength, long rafPosition) {
		String output = "";
		rafPosition = rafPosition * 2; // each char takes up 2 bytes
		try {
			RandomAccessFile raf = new RandomAccessFile(this.file, "r");
			try {
				raf.seek(rafPosition);
				for(long i = 0; i < readLength; i++) {
					output = output + raf.readChar();
				}
			} finally {
				raf.close();
			}
		} catch(IOException e) {
			System.out.println("IOException: " + e);
			e.printStackTrace();
		}
		if(output.indexOf(nullChar) > -1)
			output = output.substring(0, output.indexOf(nullChar));
		return output;
	}
}
