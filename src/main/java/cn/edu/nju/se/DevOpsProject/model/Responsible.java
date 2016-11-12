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
	int riskEntryId;
	int userId;
	// necessary?
	@ManyToOne @JoinColumn(name="riskEntryId", insertable=false, updatable=false)
	RiskEntry riskEntry;
	
	@ManyToOne @JoinColumn(name="userId", insertable=false, updatable=false)
	User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRiskEntryId() {
		return riskEntryId;
	}
	public void setRiskEntryId(int riskEntryId) {
		this.riskEntryId = riskEntryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
