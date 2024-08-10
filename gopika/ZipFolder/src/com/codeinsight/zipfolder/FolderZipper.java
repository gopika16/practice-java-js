package com.codeinsight.zipfolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FolderZipper {

	public static void main(String[] args) {
		FolderZipper folderZipper = new FolderZipper();
		try {
			folderZipper.initialProcessing();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void initialProcessing() throws IOException {
		File source = new File("C:/Users/HP/Desktop/morning/check");
		String destination = "C:/Users/HP/Desktop/morning/check.zip";
		FileOutputStream fileOutputStream = new FileOutputStream(destination);
		ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
		zipFolder(source, zipOutputStream);
		System.out.println("successful");
		zipOutputStream.closeEntry();
		zipOutputStream.close();

	}

	private void zipFolder(File source, ZipOutputStream zipOutputStream) throws IOException {

		File[] listOfFilesAndFolder = source.listFiles();
		System.out.println(listOfFilesAndFolder);
		for (File fileIterator : listOfFilesAndFolder) {
			System.out.println(fileIterator);
			if (fileIterator.isDirectory()) {
				zipFolder(fileIterator, zipOutputStream);
			} else {
				zipFile(fileIterator, zipOutputStream, source);
			}
		}
	}

	private void zipFile(File currentFilePath, ZipOutputStream zipOutputStream, File source) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(currentFilePath);
		String fileName = currentFilePath.getName();
		String entryName = source.getName() + "/" + fileName;
		ZipEntry zipEntry = new ZipEntry(entryName);

		zipOutputStream.putNextEntry(zipEntry);

		int lengthToBeRead = 0;
		try {
			while ((lengthToBeRead = fileInputStream.read()) != -1) {
				zipOutputStream.write(lengthToBeRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fileInputStream.close();
		}

	}

}
