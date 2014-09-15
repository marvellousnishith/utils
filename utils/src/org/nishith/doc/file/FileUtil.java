/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nishith.doc.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides utility methods for files.
 *
 * @author Nisheeth Shah
 * @version %I%, %G%
 */
public class FileUtil {

    public static boolean fileExists(String absolutePath) {
        File file = new File(absolutePath);
        return file.exists();
    }

    public static Map<String, String> getFileMetadata(String absolutePath) {
        HashMap<String, String> map = null;
        File file = new File(absolutePath);
        Path path = file.toPath();
        BasicFileAttributes attrs;
        try {
            map = new HashMap<String, String>();
            map.put("File Name", file.getName());
            map.put("File Parent", file.getParent());
            map.put("Path", file.getPath());
            map.put("Absolute Path", file.getAbsolutePath());
            map.put("Canonical Path", file.getCanonicalPath());
            map.put("Executable", file.canExecute() + "");
            map.put("Readable", file.canRead() + "");
            map.put("Writable", file.canWrite() + "");
            if (file.isFile()) {
                map.put("Type", "File");
            } else if (file.isDirectory()) {
                map.put("Type", "Folder (Directory)");
            }
            map.put("Hidden", file.isHidden() + "");
            map.put("Last Modified", new Date(file.lastModified()).toString());
            map.put("Size", file.length() + " bytes");
            attrs = Files.readAttributes(path, BasicFileAttributes.class);
            map.put("Creation Time", attrs.creationTime().toString());
//            map.put("File Key", attrs.fileKey().toString());
            map.put("Directory", attrs.isDirectory() + "");
            map.put("Other", attrs.isOther() + "");
            map.put("Regular File", attrs.isRegularFile() + "");
            map.put("Symbolic Link", attrs.isSymbolicLink() + "");
            map.put("Last Access Time", attrs.lastAccessTime().toString());
            map.put("Last Modified Time", attrs.lastModifiedTime().toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return map;
    }
}
