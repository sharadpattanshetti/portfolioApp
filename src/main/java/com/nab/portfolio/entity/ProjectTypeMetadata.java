
package com.nab.portfolio.entity;

/**
 * Enumeration for ProjectType data
 * 
 * @author Sharad
 *
 */

public enum ProjectTypeMetadata {
	DocsManagement("Docs Management"),
	Securities_AND_Collateral("Securities & Collateral");
	
	private String description;

	ProjectTypeMetadata(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}