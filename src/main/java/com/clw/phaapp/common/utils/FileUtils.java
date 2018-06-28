package com.clw.phaapp.common.utils;

import java.io.File;

/**
 * 文件工具类
 * 
 * @version 1.0.0
 * 
 * @date 2017年7月27日
 *
 * @author jsws
 */
public abstract class FileUtils {
	
	/**
	 * 通过文件路径获取文件名
	 * @param filePath 文件的路径
	 * @return
	 */
	public static String getNameFromFilePath(String filePath) {
        int pos = filePath.lastIndexOf('/');
        if (pos != -1) {
            return filePath.substring(pos + 1);
        }
        return "";
    }
	
	/**
	 * 通过文件名称获取文件的后缀名，不带.号
	 * @param fileName
	 * @return
	 */
	public static String getSuffixFromFileName(String fileName){
		int pos = fileName.lastIndexOf('.');
		if(pos!=-1){
			return fileName.substring(pos+1);
		}
		return "";
	}
	
	/**
	 * 修改文件名称
	 * @param file 要修改名称的文件对象
	 * @param newFileName 新文件名称
	 * @return
	 */
	public static boolean renameFile(File file,String newFileName){
		boolean result=false;
		if(file.exists()){
			//获取文件的父目录路径
			String parentPath=file.getParent()+File.separator;
			//获取文件后缀名
			String suffix="."+getSuffixFromFileName(file.getName());
			String newFilePath=parentPath+newFileName+suffix;
			//更名
			File newFile=new File(newFilePath);
			result=file.renameTo(newFile);
		}
		return result;
	}
}
