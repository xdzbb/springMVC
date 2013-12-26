package com.mvc.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment")
public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer modelid;
	private String model;
	private Integer userid;
	private String content;
	private Integer time;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Integer id, Integer modelid, Integer userid, String content) {
		this.id = id;
		this.modelid = modelid;
		this.userid = userid;
		this.content = content;
	}

	/** full constructor */
	public Comment(Integer id, Integer modelid, String model, Integer userid,
			String content, Integer time) {
		this.id = id;
		this.modelid = modelid;
		this.model = model;
		this.userid = userid;
		this.content = content;
		this.time = time;
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

	@Column(name = "userid", nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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