package com.codeinsight.unzipfile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;


public class FileUnzipper {

		public void extracting(ZipInputStream zipInputStream,BufferedOutputStream bufferedOutputStream) throws IOException {

			int lengthToBeRead = 0;
				while ((lengthToBeRead = zipInputStream.read()) != -1) {
					bufferedOutputStream.write(lengthToBeRead);
				}
				System.out.println("successful");
				bufferedOutputStream.close();

			}
		}