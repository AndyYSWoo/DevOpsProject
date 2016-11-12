package cn.edu.nju.se.DevOpsProject.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="risk")
public class Risk {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String title;
	String content;
	int submitterId;
	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch=FetchType.EAGER, targetEntity=RiskEntry.class, cascade=CascadeType.ALL, mappedBy="riskId")
	@OrderBy("id DESC")
	List<RiskEntry> entries;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSubmitterId() {
		return submitterId;
	}
	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}
	public List<RiskEntry> getEntries() {
		return entries;
	}
	public void setEntries(List<RiskEntry> entries) {
		this.entries = entries;
	}
}
