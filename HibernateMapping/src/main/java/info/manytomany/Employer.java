package info.manytomany;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employer {
	
	@Id
	@Column(name = "employer_id")
	private int epmloyerId;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany
	@JoinTable(
			name="emp_project",
			joinColumns = {@JoinColumn(name="emp_id")},
			inverseJoinColumns = {@JoinColumn(name="pro_id")})
	private List<Project> projects;
	
	public Employer() {}

	public Employer(int epmloyerId, String name, List<Project> projects) {
		super();
		this.epmloyerId = epmloyerId;
		this.name = name;
		this.projects = projects;
	}

	public int getEpmloyerId() {
		return epmloyerId;
	}

	public void setEpmloyerId(int epmloyerId) {
		this.epmloyerId = epmloyerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employer [epmloyerId=" + epmloyerId + ", name=" + name + ", projects=" + projects + "]";
	}
	
}
