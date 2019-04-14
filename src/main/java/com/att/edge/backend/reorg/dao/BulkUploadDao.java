/**
 * 
 */
package com.att.edge.backend.reorg.dao;

import java.util.List;
import java.util.Set;

public interface BulkUploadDao {
	
	 public int[] batchUpdateAdmin( Set<String> fileNames);
}
