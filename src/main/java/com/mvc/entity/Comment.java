package com.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "mvcdb")
public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tuser tuser;
	private Integer modelid;
	private String model;
	private String content;
	private Integer time;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Integer id, Tuser tuser, Integer modelid, String content) {
		this.id = id;
		this.tuser = tuser;
		this.modelid = modelid;
		this.content = content;
	}

	/** full constructor */
	public Comment(Integer id, Tuser tuser, Integer modelid, String model,
			String content, Integer time) {
		this.id = id;
		this.tuser = tuser;
		this.modelid = modelid;
		this.model = model;
		this.content = content;
		this.time = time;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	@Column(name = "modelid", nullable = false)
	public Integer getModelid() {
		return this.modelid;
	}

	public void setModelid(Integer modelid) {
		this.modelid = modelid;
	}

	@Column(name = "model", length = 20)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "content", nullable = false, length = 256)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "time")
	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}