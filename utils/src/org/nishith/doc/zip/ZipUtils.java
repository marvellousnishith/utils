/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nishith.doc.zip;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author Nisheeth Shah
 */
public class ZipUtils {

    public static List<String> getZippedFileList(String absolutePath) {
        ZipFile file;
        List<String> fileList = new ArrayList<String>();
        try {
            file = new ZipFile(absolutePath);
            Enumeration<? extends ZipEntry> enm = file.entries();
            while (enm.hasMoreElements()) {
                ZipEntry entry = enm.nextElement();
                fileList.add(entry.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileList;
    }
}
