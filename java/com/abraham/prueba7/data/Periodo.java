package com.abraham.prueba7.data;
// Generated 29-dic-2016 12:33:52 by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Periodo generated by hbm2java
 */
@Entity
@Table(name = "periodo", schema = "public")
public class Periodo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idperiodo;
	private String periodo;
	private Set<Tanda> tandas = new HashSet<Tanda>(0);

	public Periodo() {
	}

	public Periodo(int idperiodo) {
		this.idperiodo = idperiodo;
	}

	public Periodo(int idperiodo, String periodo, Set<Tanda> tandas) {
		this.idperiodo = idperiodo;
		this.periodo = periodo;
		this.tandas = tandas;
	}

	@Id

	@Column(name = "idperiodo", unique = true, nullable = false)
	public int getIdperiodo() {
		return this.idperiodo;
	}

	public void setIdperiodo(int idperiodo) {
		this.idperiodo = idperiodo;
	}

	@Column(name = "periodo", length = 20)
	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "periodo")
	public Set<Tanda> getTandas() {
		return this.tandas;
	}

	public void setTandas(Set<Tanda> tandas) {
		this.tandas = tandas;
	}

}
