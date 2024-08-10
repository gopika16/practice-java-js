package com.codeinsight.filezipper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZipper {

	public static void main(String[] args) {
		FileZipper fileZipper = new FileZipper();
		File sourceFile = new File("C:/Users/HP/Desktop/morning/power.pptx");
		try {
			fileZipper.zipFile(sourceFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	void zipFile(File sourcePath) throws FileNotFoundException {
		String destination = "C:/Users/HP/Desktop/morning/power.zip";
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourcePath));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destination));
		ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);

		int lengthToBeRead = 0;
		String getFileName = sourcePath.getName();
		try {
			zipOutputStream.putNextEntry(new ZipEntry(getFileName));
			while ((lengthToBeRead = bufferedInputStream.read()) != -1) {
				zipOutputStream.write(lengthToBeRead);
			}

			System.out.println("successful");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				zipOutputStream.closeEntry();
				zipOutputStream.close();
				bufferedInputStream.close();
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
