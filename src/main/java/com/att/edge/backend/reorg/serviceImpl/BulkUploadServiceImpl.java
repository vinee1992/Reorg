/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.BulkUploadDao;
import com.att.edge.backend.reorg.service.BulkUploadService;

/**
 * @author anand.arjan.jhamnani
 *
 */
@Service("bulkUploadService")
public class BulkUploadServiceImpl implements BulkUploadService {
	@Autowired
	BulkUploadDao bulkUploadDao;

	@Override
	public int[] UpdateBulkStatus(Set<String> fileNames) {
		// TODO Auto-generated method stub
		return bulkUploadDao.batchUpdateAdmin(fileNames);
	}
	
	
}
