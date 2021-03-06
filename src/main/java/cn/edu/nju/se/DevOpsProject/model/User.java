package cn.edu.nju.se.DevOpsProject.model;

import javax.persistence.GeneratedValue;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="user")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	String email;
	String psw;
	int role;// 0: PM, 1: RD
	int status;// 0: inactive, 1: active
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch=FetchType.EAGER, targetEntity=Responsible.class, cascade=CascadeType.ALL, mappedBy="userId")
	List<Responsible> responsibles;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<Responsible> getResponsibles() {
		return responsibles;
	}
	public void setResponsibles(List<Responsible> responsibles) {
		this.responsibles = responsibles;
	}
}
