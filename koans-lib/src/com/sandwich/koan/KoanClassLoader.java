package com.sandwich.koan;

import java.io.File;

import com.sandwich.util.io.DynamicClassLoader;
import com.sandwich.util.io.FileMonitorFactory;
import com.sandwich.util.io.directories.DirectoryManager;

public class KoanClassLoader extends ClassLoader {

	private static DynamicClassLoader instance = new DynamicClassLoader(
		DirectoryManager.getBinDir(), DirectoryManager.getSourceDir(),
		new String[]{DirectoryManager.getProjectLibraryDir() + DirectoryManager.FILESYSTEM_SEPARATOR + "koans.jar"},
		FileMonitorFactory.getInstance(new File(DirectoryManager.getProdMainDir()), new File(DirectoryManager.getDataFile())));
	
	public static DynamicClassLoader getInstance(){
		return instance.clone();
	}
	
}
