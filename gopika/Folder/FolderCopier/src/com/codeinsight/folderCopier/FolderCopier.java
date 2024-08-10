package com.codeinsight.folderCopier;

import java.io.File;
import java.io.IOException;

public class FolderCopier {

	public static void main(String[] args) {
		FolderCopier folderCopier = new FolderCopier();
		folderCopier.processingFolder();
	}

	private void processingFolder(){
		File source = new File("C:/Users/HP/Desktop/morning/che");
		try {
			if (source.exists());
			String getName = source.getName();
			File destination = new File("C:/Users/HP/Desktop/evening", getName);
			copyFolder(source, destination);
			System.out.print("Successful");
		} catch (IOException e) {
			System.out.print("Error in source path");
		}
	}

	private void copyFolder(File source, File destination) throws IOException {
		if (source.isDirectory()) {
			createFolder(destination);
			String[] listOfFilesAndFolder = source.list();
			for (String fileIterator : listOfFilesAndFolder) {
				File fileSource = new File(source, fileIterator);
				File fileDestination = new File(destination, fileIterator);
				copyFolder(fileSource, fileDestination);
			}
		}

		else {
			filesCopier(source, destination);
		}
	}

	private void createFolder(File destination) {
		destination.mkdir();
	}

	private void filesCopier(File source, File destination) throws IOException {
		FileCopier fileCopier = new FileCopier();
		fileCopier.copyingFile(source, destination);
	}
}
