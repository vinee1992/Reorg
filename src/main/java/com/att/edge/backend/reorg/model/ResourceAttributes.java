/**
 * 
 */
package com.att.edge.backend.reorg.model;

import java.util.List;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class ResourceAttributes {
	private List<ResourceAttribute> resourcesAttributes;

	/**
	 * @return the resourcesAttributes
	 */
	public List<ResourceAttribute> getResourcesAttributes() {
		return resourcesAttributes;
	}

	/**
	 * @param resourcesAttributes the resourcesAttributes to set
	 */
	public void setResourcesAttributes(List<ResourceAttribute> resourcesAttributes) {
		this.resourcesAttributes = resourcesAttributes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResourceAttributes [resourcesAttributes=" + resourcesAttributes + "]";
	}

	

}
