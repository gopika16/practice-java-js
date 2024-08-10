package com.codeinsight.fileCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier {

	public static void main(String[] args) {
		
		FileCopier fileCopier = new FileCopier();
		fileCopier.copyingFile();

	}
	
	
	public void copyingFile() {
		
		FileInputStream inputStream = null ;
		FileOutputStream outputStream = null ;
		
		
		
		try {
			
		File sourceFile = new File("C:/Users/HP/Desktop/morning/power.pptx");
		File destinationLocation = new File("C:/Users/HP/Desktop/evening/check/pt.pptx");
		
		
		inputStream = new FileInputStream(sourceFile);
		outputStream = new FileOutputStream(destinationLocation);
		
		int availableBytes = inputStream.available();
		
		byte[] buffer = new byte[availableBytes];
		int length;
		
		while((length = inputStream.read(buffer)) > 0) 
			{
				outputStream.write(buffer , 0 , length);
//				outputStream.flush();
			}
		}
		
		
		
		catch(IOException e) {
			System.out.print("Unable to copy");
		}
		
		
		
		finally {
			try {
				inputStream.close();
				outputStream.close();
			}
			catch (Exception ex) {
		}
		
		
	}

}
}
