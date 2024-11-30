package part01;

public class Artifact {
	private static int nextId = 0;
	private int id;
	private String name;
	private ArtifactType type;
	private int engagementTime; // measured in minutes
	private String sign;
	
	/**
	 * Constructor for artifact.
	 * @param name - name of the artifact.
	 * @param type - type of the artifact.
	 * @param engagementTime - engagement time of the artifact.
	 * @param sign - the text shown on the artifact's sign.
	 * @throws Exception if the name is null or empty.
	 * @throws Exception if the type is null.
	 * @throws Exception if the engagement time is less than or equal to 0.
	 * @throws Exception if the sign text is null or empty.
	 */
	public Artifact(String name, ArtifactType type, int engagementTime, String sign) throws Exception {
		if (!setName(name)) {
			throw new Exception("Exhibit name cannot be null or empty.");
		}
		
		if (!setType(type)) {
			throw new Exception("Artifact type cannot be null.");
		}
		
		if (!setEngagementTime(engagementTime)) {
			throw new Exception("Engagement time must be greater than 0.");
		}
		
		if (!setSign(sign)) {
			throw new Exception("Sign text cannot be null or empty.");
		}
		
		this.id = nextId;
		nextId++;
	}
	
	/**
	 * Gets the id.
	 * @return id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Gets the name.
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the type.
	 * @return type
	 */
	public ArtifactType getType() {
		return this.type;
	}
	
	/**
	 * Gets the engagement time.
	 * @return engagement time.
	 */
	public int getEngagementTime() {
		return this.engagementTime;
	}
	
	/**
	 * Gets the sign text.
	 * @return sign
	 */
	public String getSign() {
		return this.sign;
	}
	
	/**
	 * Sets the name.
	 * @param name
	 * @return true if the set was successful, false otherwise.
	 */
	public boolean setName(String name) {
		// Is the string null or empty?
		if (Resources.isStringNullOrEmpty(name)) {
			return false;
		}
		
		this.name = name;
		return true;
	}
	
	/**
	 * Sets the type.
	 * @param type
	 * @return true if set is successful, false otherwise.
	 */
	public boolean setType(ArtifactType type) {
		// Is the type null?
		if (type == null) {
			return false;
		}
		
		this.type = type;
		return true;
	}
	
	/**
	 * Sets the engagement time.
	 * @param engagementTime
	 * @return true if set is successful, false otherwise.
	 */
	public boolean setEngagementTime(int engagementTime) {
		// Is the engagement time less than or equal to zero?
		if (engagementTime <= 0) {
			return false;
		}
		
		this.engagementTime = engagementTime;
		return true;
	}
	
	/**
	 * Sets the sign text.
	 * @param sign - sign text.
	 * @return true if set is successful, false otherwise.
	 */
	public boolean setSign(String sign) {
		// Is the string null or empty?
		if (Resources.isStringNullOrEmpty(sign)) {
			return false;
		}
		
		this.sign = sign;
		return true;
	}

	/**
	 * Returns the string representation of the artifact.
	 * @return the string representation of the artifact.
	 */
	@Override
	public String toString() {
		return "Artifact [id=" + id + ", name=" + name + ", type=" + type + ", engagementTime=" + engagementTime + "]";
	}
}
