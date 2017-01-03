package com.abraham.prueba7.data;
// Generated 03-ene-2017 12:05:03 by Hibernate Tools 5.1.0.Alpha1

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

/**
 * Involucrado generated by hbm2java
 */
@Entity
@Table(name = "involucrado", schema = "public")
public class Involucrado implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idit;
	private Tanda tanda;
	private Usuario usuario;
	private Integer numerot;
	private Boolean pentregado;
	private Integer adeudo;
	private Set<Pago> pagos = new HashSet<Pago>(0);

	public Involucrado() {
	}

	public Involucrado(int idit) {
		this.idit = idit;
	}

	public Involucrado(int idit, Tanda tanda, Usuario usuario, Integer numerot, Boolean pentregado, Integer adeudo,
			Set<Pago> pagos) {
		this.idit = idit;
		this.tanda = tanda;
		this.usuario = usuario;
		this.numerot = numerot;
		this.pentregado = pentregado;
		this.adeudo = adeudo;
		this.pagos = pagos;
	}

	@Id

	@Column(name = "idit", unique = true, nullable = false)
	public int getIdit() {
		return this.idit;
	}

	public void setIdit(int idit) {
		this.idit = idit;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtanda")
	public Tanda getTanda() {
		return this.tanda;
	}

	public void setTanda(Tanda tanda) {
		this.tanda = tanda;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iduser")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "numerot")
	public Integer getNumerot() {
		return this.numerot;
	}

	public void setNumerot(Integer numerot) {
		this.numerot = numerot;
	}

	@Column(name = "pentregado")
	public Boolean getPentregado() {
		return this.pentregado;
	}

	public void setPentregado(Boolean pentregado) {
		this.pentregado = pentregado;
	}

	@Column(name = "adeudo")
	public Integer getAdeudo() {
		return this.adeudo;
	}

	public void setAdeudo(Integer adeudo) {
		this.adeudo = adeudo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "involucrado")
	public Set<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

}
