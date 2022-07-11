package info.onetomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@Column(name = "dept_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long did;
	String dName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id", referencedColumnName = "dept_id")
	Set<Employee> emps;

	public Long getId() {
		return did;
	}

	public void setId(Long id) {
		this.did = id;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

}
