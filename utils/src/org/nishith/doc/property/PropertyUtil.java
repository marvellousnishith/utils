/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nishith.doc.property;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nisheeth Shah
 */
public class PropertyUtil {

    /**
     * <p>
     * This method reads properties of given property file.</p>
     *
     * @param filename relative path of the property file
     * @return {@link Map} of the properties within the file
     */
    public static Map<String, String> readProperties(String filename) {
        Properties props = new Properties();
        InputStream is = null;
        HashMap<String, String> propertyMap = new HashMap<String, String>();
        try {
            is = PropertyUtil.class.getResourceAsStream(filename);
            props.load(is);
            Set<Object> set = props.keySet();
            Iterator<Object> itr = set.iterator();
            while (itr.hasNext()) {
                String key = (String) itr.next();
                propertyMap.put(key, props.getProperty(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertyUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return propertyMap;
    }

    /**
     * <p>
     * This method writes the properties from the {@link Map} in the file of
     * given path</p>
     *
     * @param propertyMap a {@link Map} that contains the properties
     * @param path a path to the file where the properties to be written
     */
    public static void writeProperties(Map<String, String> propertyMap, String path) {
        Properties props = new Properties();
        OutputStream os = null;
        try {
            os = new FileOutputStream(path, true);
            Iterator<String> iterator = propertyMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                props.setProperty(key, propertyMap.get(key));
            }
            props.store(os, "This is a file written using java property writer");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
