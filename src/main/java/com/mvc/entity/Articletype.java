package com.mvc.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Articletype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "articletype")
public class Articletype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typename;

	// Constructors

	/** default constructor */
	public Articletype() {
	}

	/** full constructor */
	public Articletype(Integer id, String typename) {
		this.id = id;
		this.typename = typename;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "typename", nullable = false, length = 256)
	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}