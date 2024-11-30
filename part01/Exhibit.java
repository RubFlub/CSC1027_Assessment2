package part01;

import java.util.ArrayList;

public class Exhibit {
	private static int nextId = 0;
	private int id;
	private String name;
	private ArrayList<Artifact> route = new ArrayList<Artifact>();
	
	/**
	 * Constructor for exhibit.
	 * @param name - name of the exhibit.
	 * @throws Exception if the name is null or empty.
	 */
	public Exhibit(String name) throws Exception {
		if (!setName(name)) {
			throw new Exception("Exhibit name cannot be null or empty.");
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
	 * Gets the route ArrayList.
	 * @return route
	 */
	public ArrayList<Artifact> getRoute() {
		return this.route;
	}
	
	/**
	 * Calculates and returns the engagement time of the route.
	 * @return engagement time
	 */
	public int getTotalEngagementTime() {
		int total = 0;
		for (Artifact artifact : route) {
			total += artifact.getEngagementTime();
		}
		
		return total;
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
	 * Adds an artifact to the end of the route.
	 * @param artifact
	 * @return true if add is successful, false otherwise.
	 */
	public boolean addArtifactToRoute(Artifact artifact) {
		if (artifact == null) {
			return false;
		}
		
		route.add(artifact);
		return true;
	}

	/**
	 * Returns the string representation of the exhibit.
	 * @return the string representation of the exhibit.
	 */
	@Override
	public String toString() {
		return "Exhibit [id=" + id + ", name=" + name + ", route=" + route + "]";
	}
}
