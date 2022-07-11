package info.manytomany;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Project {
	
	@Id
	@Column(name = "project_id")
	private int projectId;
	
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany
	@JoinTable(name="project_emp")
	private List<Employer> emp;
	
	public Project() {}

	public Project(int projectId, String projectName, List<Employer> emp) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.emp = emp;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employer> getEmp() {
		return emp;
	}

	public void setEmp(List<Employer> emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", emp=" + emp + "]";
	}
	
	

}
