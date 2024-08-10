package com.codeinsight.fileCopyUsingBuffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier {

	public static void main(String[] args) throws IOException {

		FileCopier fileCopier = new FileCopier();
		fileCopier.copyingFile();

	}

	private void copyingFile() throws IOException {
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream("C:/Users/HP/Desktop/morning/js.zip"));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("C:/Users/HP/Desktop/evening/js.zip"));

			int lengthToBeRead = 0;
			while ((lengthToBeRead = bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(lengthToBeRead);
			}
		} catch (IOException e) {
			System.out.print("Unable to copy");
		} finally {

			bufferedInputStream.close();
			bufferedOutputStream.close();

		}
	}
}
