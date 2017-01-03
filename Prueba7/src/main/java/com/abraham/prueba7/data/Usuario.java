package com.abraham.prueba7.data;
// Generated 03-ene-2017 12:05:03 by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int iduser;
	private String nombreu;
	private String apu;
	private String amu;
	private String login;
	private String password;
	private Boolean activou;
	private Set<Involucrado> involucrados = new HashSet<Involucrado>(0);
	private Set<Ejerce> ejerces = new HashSet<Ejerce>(0);

	public Usuario() {
	}

	public Usuario(int iduser, String login) {
		this.iduser = iduser;
		this.login = login;
	}

	public Usuario(int iduser, String nombreu, String apu, String amu, String login, String password, Boolean activou,
			Set<Involucrado> involucrados, Set<Ejerce> ejerces) {
		this.iduser = iduser;
		this.nombreu = nombreu;
		this.apu = apu;
		this.amu = amu;
		this.login = login;
		this.password = password;
		this.activou = activou;
		this.involucrados = involucrados;
		this.ejerces = ejerces;
	}

	@Id

	@Column(name = "iduser", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	@Column(name = "nombreu", length = 30)
	public String getNombreu() {
		return this.nombreu;
	}

	public void setNombreu(String nombreu) {
		this.nombreu = nombreu;
	}

	@Column(name = "apu", length = 30)
	public String getApu() {
		return this.apu;
	}

	public void setApu(String apu) {
		this.apu = apu;
	}

	@Column(name = "amu", length = 30)
	public String getAmu() {
		return this.amu;
	}

	public void setAmu(String amu) {
		this.amu = amu;
	}

	@Column(name = "login", nullable = false, length = 20)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "activou")
	public Boolean getActivou() {
		return this.activou;
	}

	public void setActivou(Boolean activou) {
		this.activou = activou;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Involucrado> getInvolucrados() {
		return this.involucrados;
	}

	public void setInvolucrados(Set<Involucrado> involucrados) {
		this.involucrados = involucrados;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Ejerce> getEjerces() {
		return this.ejerces;
	}

	public void setEjerces(Set<Ejerce> ejerces) {
		this.ejerces = ejerces;
	}

}
