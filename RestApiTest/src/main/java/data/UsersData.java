package data;

//pojo -plain old java object
public class UsersData {
	String name;
	String job;
	String id;
	String CreatedAt;

	public UsersData() {

	}

	public UsersData(String name, String job) {
		this.name = name;
		this.job = job;
	}

// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(String createdAt) {
		CreatedAt = createdAt;
	}

}
