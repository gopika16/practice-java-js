package com.codeinsight.zipextractor;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

public class ZipExtractor {

	public static void main(String[] args) {
		ZipExtractor zipExtractor = new ZipExtractor();
		File source = new File("C:/Users/HP/Desktop/morning/power.zip");
		try {
			zipExtractor.extracting(source);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void extracting(File source) throws FileNotFoundException {
		String destination = "C:/Users/HP/Desktop/morning/power.pptx";
		FileInputStream fileInputStream = new FileInputStream(source);
		ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
		FileOutputStream fileOutputStream = new FileOutputStream(destination);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

		int lengthToBeRead = 0;
		try {
			zipInputStream.getNextEntry();
			while ((lengthToBeRead = zipInputStream.read()) != -1) {
				bufferedOutputStream.write(lengthToBeRead);
			}
			System.out.println("successful");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				zipInputStream.closeEntry();
				zipInputStream.close();
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
