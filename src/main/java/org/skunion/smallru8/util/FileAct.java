package org.skunion.smallru8.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;

public class FileAct {

	public static void deleteFile(File file) {
		try {
			if(file.isDirectory())
				FileUtils.deleteDirectory(file);
			else if(file.isFile())
				file.delete();
			
			while(file.exists())
				Thread.sleep(100);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	* @param oldpath Directory you want to copy
	* @param newpath Dst path
	*/
	public static void copy(File oldpath,File newpath){
		if(oldpath.isDirectory()){//Copy folder
			newpath.mkdir();
			File[] oldList = oldpath.listFiles();
			if(oldList!=null){
				for (File file : oldList) {
					copy(file, new File(newpath,file.getName()));
				}
			}
		}else if(oldpath.isFile()){//Copy file
			File f=new File(newpath.getAbsolutePath());
			try {
				f.createNewFile();
				copyFile(oldpath,f.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	* @param filepath File you want to copy
	* @param path Dst path
	*/
	public static void copyFile(File filepath,String path){
		try {
			InputStream is=new FileInputStream(filepath);
			OutputStream os=new FileOutputStream(path);
		
			BufferedInputStream bis=new BufferedInputStream(is);
			BufferedOutputStream bos=new BufferedOutputStream(os);
		
		
			byte[] bs=new byte[1024];
			int len=-1;
			while((len=bis.read(bs))!=-1){
				bos.write(bs, 0, len);
			}
			bos.close();
			bis.close();
		} catch (IOException e) {
			System.out.println(filepath+" "+path);
			e.printStackTrace();
		}
	}
	
}
