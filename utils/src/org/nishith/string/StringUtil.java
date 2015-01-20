package org.nishith.string;

import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <code>StringUtil</code> class contains additional common functions for String
 * literals.
 *
 * @author Nisheeth Shah
 */
public class StringUtil {

    /**
     * Replaces multiple spaces to single space between two literals and trims
     * leading and trailing spaces of given string.
     *
     * @param literal
     * @return {@link String}
     */
    @NotNull
    public static String truncateMultipleSpaces(String literal) {
        return literal != null ? literal.replaceAll("[\\s]+", " ").trim() : "";
    }

    /**
     * Converts all the objects from the collections to a string and separates
     * them using a delimiter. toString() of the object that is contained in the
     * collection must be override to get better user if the class is other then
     * String and Wrapper types.
     *
     * @param collection
     * @param delimiter a literal or a character to be used to separate the
     * string.
     * @return
     */
    public static String collectionToString(Collection<? extends Object> collection, String delimiter) {
        StringBuilder result = new StringBuilder();
        List<Object> list = new ArrayList<>();
        list.addAll(collection);
        if (delimiter == null) {
            delimiter = ",";
        }
        for (Object obj : list) {
            result.append(obj.toString());
            if (list.indexOf(obj) + 1 < list.size()) {
                result.append(delimiter);
            }
        }
        return result.toString();
    }
}
