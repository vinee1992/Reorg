/**
 * 
 */
package com.att.edge.backend.reorg.model;

import java.util.List;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class TechAttributes {
	private List<TechAttribute> techAttributes;


	/**
	 * @return the techAttributes
	 */
	public List<TechAttribute> getTechAttributes() {
		return techAttributes;
	}

	/**
	 * @param techAttributes the techAttributes to set
	 */
	public void setTechAttributes(List<TechAttribute> techAttributes) {
		this.techAttributes = techAttributes;
	}

	@Override
	public String toString() {
		return "TechAttributes [techAttributes=" + techAttributes + "]";
	}



}
