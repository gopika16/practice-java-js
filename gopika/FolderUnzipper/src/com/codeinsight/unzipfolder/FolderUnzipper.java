package com.codeinsight.unzipfolder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.codeinsight.unzipfile.FileUnzipper;

public class FolderUnzipper {

	public static void main(String[] args) {
		FolderUnzipper folderUnzipper = new FolderUnzipper();
		try {
			folderUnzipper.initialProcessing();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initialProcessing() throws IOException {
		File source = new File("C:/Users/HP/Desktop/morning/check.zip");
		File destination = new File("C:/Users/HP/Desktop/morning/unzipedFolderCheck");	
		destination.getParentFile().mkdirs();
		unzipFolder(source, destination);
	}

	private void unzipFolder(File source, File destination) throws IOException {
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(source));
		try {
			ZipEntry zipEntry;
			while ((zipEntry = zipInputStream.getNextEntry()) != null) {
				File destinationPath = new File(destination+File.separator+zipEntry.getName());
				destinationPath.getParentFile().mkdirs();
				FileOutputStream fileOutputStream = new FileOutputStream(destinationPath);
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
				unzipFile(zipInputStream, bufferedOutputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			zipInputStream.closeEntry();
		}
	}
	private void unzipFile(ZipInputStream zipInputStream, BufferedOutputStream bufferedOutputStream)
			throws IOException {
		FileUnzipper zipExtractor = new FileUnzipper();
		zipExtractor.extracting(zipInputStream, bufferedOutputStream);

	}
}
