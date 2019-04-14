/**
 * 
 */
package com.att.edge.backend.reorg.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class JsonIteratorUtil {
	/**
	 * @author pk4809
	 * This method subsitutes or sets value of Json Elements, where fieldName is the name of the field and newValue is the value
	 * that is to be set. parent is JsonNode(Complete Json). Iterates over all the fields.
	 *
	 */
	public static void change(JsonNode parent, String fieldName, String newValue) {
        if (parent.has(fieldName)) {
            ((ObjectNode) parent).put(fieldName, newValue);
        }

        // Now, recursively invoke this method on all properties
        for (JsonNode child : parent) {
            change(child, fieldName, newValue);
        }
	}
}
