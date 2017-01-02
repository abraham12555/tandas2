package com.abraham.prueba7.data;
// Generated 29-dic-2016 12:33:52 by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tanda generated by hbm2java
 */
@Entity
@Table(name = "tanda", schema = "public")
public class Tanda implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idtanda;
	private Periodo periodo;
	private Double monto;
	private Integer npagos;
	private Date finicio;
	private Date ffinal;
	private String estatus;
	private Set<Involucrado> involucrados = new HashSet<Involucrado>(0);
	private Set<Calendariopagos> calendariopagoses = new HashSet<Calendariopagos>(0);

	public Tanda() {
	}

	public Tanda(int idtanda) {
		this.idtanda = idtanda;
	}

	public Tanda(int idtanda, Periodo periodo, Double monto, Integer npagos, Date finicio, Date ffinal, String estatus,
			Set<Involucrado> involucrados, Set<Calendariopagos> calendariopagoses) {
		this.idtanda = idtanda;
		this.periodo = periodo;
		this.monto = monto;
		this.npagos = npagos;
		this.finicio = finicio;
		this.ffinal = ffinal;
		this.estatus = estatus;
		this.involucrados = involucrados;
		this.calendariopagoses = calendariopagoses;
	}

	@Id

	@Column(name = "idtanda", unique = true, nullable = false)
	public int getIdtanda() {
		return this.idtanda;
	}

	public void setIdtanda(int idtanda) {
		this.idtanda = idtanda;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idperiodo")
	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	@Column(name = "monto", scale = 0)
	public Double getMonto() {
		return this.monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	@Column(name = "npagos")
	public Integer getNpagos() {
		return this.npagos;
	}

	public void setNpagos(Integer npagos) {
		this.npagos = npagos;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "finicio", length = 13)
	public Date getFinicio() {
		return this.finicio;
	}

	public void setFinicio(Date finicio) {
		this.finicio = finicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ffinal", length = 13)
	public Date getFfinal() {
		return this.ffinal;
	}

	public void setFfinal(Date ffinal) {
		this.ffinal = ffinal;
	}

	@Column(name = "estatus", length = 15)
	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tanda")
	public Set<Involucrado> getInvolucrados() {
		return this.involucrados;
	}

	public void setInvolucrados(Set<Involucrado> involucrados) {
		this.involucrados = involucrados;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tanda")
	public Set<Calendariopagos> getCalendariopagoses() {
		return this.calendariopagoses;
	}

	public void setCalendariopagoses(Set<Calendariopagos> calendariopagoses) {
		this.calendariopagoses = calendariopagoses;
	}

}