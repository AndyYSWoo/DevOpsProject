package cn.edu.nju.se.DevOpsProject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="risk_entry")
public class RiskEntry {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="risk_id")
	int riskId;
	int possibility;
	int influence;
	@Column(name="threshold_id")
	int thresholdId;
	@Column(name="description_id")
	int descriptionId;
	@Column(name="changer_id")
	int changerId;
	int status;
	@Column(name="created_time")
	Date createdTime;
	// necessary?
	@ManyToOne @JoinColumn(name="risk_id", insertable=false, updatable=false)
	Risk risk;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch=FetchType.EAGER,targetEntity=Responsible.class, cascade=CascadeType.ALL, mappedBy="risk_entry_id")
	List<Responsible> responsibles;
	
	@ManyToOne @JoinColumn(name="description_id", insertable=false, updatable=false)
	Description description;
	
	@ManyToOne @JoinColumn(name="threshold_id", insertable=false, updatable=false)
	Threshold threshold;
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
	public int getPossibility() {
		return possibility;
	}
	public void setPossibility(int possibility) {
		this.possibility = possibility;
	}
	public int getInfluence() {
		return influence;
	}
	public void setInfluence(int influence) {
		this.influence = influence;
	}
	public int getThresholdId() {
		return thresholdId;
	}
	public void setThresholdId(int thresholdId) {
		this.thresholdId = thresholdId;
	}
	public int getDescriptionId() {
		return descriptionId;
	}
	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}
	public int getChangerId() {
		return changerId;
	}
	public void setChangerId(int changerId) {
		this.changerId = changerId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Risk getRisk() {
		return risk;
	}
	public void setRisk(Risk risk) {
		this.risk = risk;
	}
	public List<Responsible> getResponsibles() {
		return responsibles;
	}
	public void setResponsibles(List<Responsible> responsibles) {
		this.responsibles = responsibles;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	public Threshold getThreshold() {
		return threshold;
	}
	public void setThreshold(Threshold threshold) {
		this.threshold = threshold;
	}
}
