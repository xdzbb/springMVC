package com.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article")
public class Article implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer typeid;
	private String keyword;
	private String title;
	private String content;
	private String summary;
	private Integer createtime;
	private Integer publictime;
	private Integer status;
	private Integer praisecount;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(Integer id, Integer userid, Integer typeid, String title,
			String content) {
		this.id = id;
		this.userid = userid;
		this.typeid = typeid;
		this.title = title;
		this.content = content;
	}

	/** full constructor */
	public Article(Integer id, Integer userid, Integer typeid, String keyword,
			String title, String content,String summary, Integer createtime,
			Integer publictime, Integer status, Integer praisecount) {
		this.id = id;
		this.userid = userid;
		this.typeid = typeid;
		this.keyword = keyword;
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.createtime = createtime;
		this.publictime = publictime;
		this.status = status;
		this.praisecount = praisecount;
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

	@Column(name = "userid", nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "typeid", nullable = false)
	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	@Column(name = "keyword", length = 20)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "title", nullable = false, length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "summary", nullable = false, length = 100)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "createtime")
	public Integer getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}

	@Column(name = "publictime")
	public Integer getPublictime() {
		return this.publictime;
	}

	public void setPublictime(Integer publictime) {
		this.publictime = publictime;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "praisecount")
	public Integer getPraisecount() {
		return this.praisecount;
	}

	public void setPraisecount(Integer praisecount) {
		this.praisecount = praisecount;
	}

}