/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nishith.doc.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is a utility class that provides utility methods.
 *
 * @author Nisheeth Shah
 */
public class DocUtil {

    public static void printMap(Map map) {
        Iterator itr = map.keySet().iterator();
        System.out.println("-----Printing Map-----");
        while (itr.hasNext()) {
            Object obj = itr.next();
            System.out.println(obj + " : " + map.get(obj));
        }
        System.out.println("-----End Of Map-----");
    }

    public static void printCollection(Collection collection) {
        Iterator itr = collection.iterator();
        System.out.println("-----Printing Collection-----");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("-----End Of Collection-----");
    }
}
