package cn.edu.nju.se.DevOpsProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="responsible")
public class Responsible {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	int riskId;
	int userId;
	// necessary?
	@ManyToOne @JoinColumn(name="riskId", insertable=false, updatable=false)
	Risk risk;
	
	@ManyToOne @JoinColumn(name="userId", insertable=false, updatable=false)
	User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRiskId() {
		return riskId;
	}

	public void setRiskId(int riskId) {
		this.riskId = riskId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
