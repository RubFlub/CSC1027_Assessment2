package part01;

/**
 * Represents a type of artifact.
 */
public enum ArtifactType {
	PAINTING("Painting"),
	SCULPTURE("Sculpture"),
	CLOTHING("Clothing"),
	PHOTOGRAPH("Photograph"),
	MACHINE("Machine"),
	DIGITAL("Digital"),
	FOSSIL("Fossil"),
	MATERIAL("Material"),
	MANUSCRIPT("Manuscript"),
	WEAPON("Weapon"),
	FLAG("Flag"),
	OTHER("Other");
	
	private static final ArtifactType[] ENUMS = ArtifactType.values();
	
	private String artifactString;
	
	private ArtifactType(String artifactString) {
		this.artifactString = artifactString;
	}
	
	/**
	 * Returns the string representation of the artifact type.
	 * @return the string representation of the artifact type.
	 */
	public String toString() {
		return this.artifactString;
	}
	
	/**
	 * Returns the specified artifact type from an index.
	 * @param index the index of the specified value.
	 * @throws Exception if the index is out of bounds.
	 * @return the specified value.
	 */
	public static ArtifactType get(int index) throws Exception {
		if (index < 0 || index >= ENUMS.length) {
			throw new Exception("Invalid value for index: " + index);
		}
		return ENUMS[index];
	}
}
