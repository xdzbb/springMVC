package com.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article", catalog = "mvcdb")
public class Article implements java.io.Serializable {

	// Fields

	private Integer id;
	private Articletype articletype;
	private Tuser tuser;
	private String keyword;
	private String title;
	private String content;
	private Integer createtime;
	private Integer publictime;
	private Integer status;
	private Integer praisecount;
	private String summary;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(Integer id, Articletype articletype, Tuser tuser,
			String title, String content, String summary) {
		this.id = id;
		this.articletype = articletype;
		this.tuser = tuser;
		this.title = title;
		this.content = content;
		this.summary = summary;
	}

	/** full constructor */
	public Article(Integer id, Articletype articletype, Tuser tuser,
			String keyword, String title, String content, Integer createtime,
			Integer publictime, Integer status, Integer praisecount,
			String summary) {
		this.id = id;
		this.articletype = articletype;
		this.tuser = tuser;
		this.keyword = keyword;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
		this.publictime = publictime;
		this.status = status;
		this.praisecount = praisecount;
		this.summary = summary;
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
	@JoinColumn(name = "typeid", nullable = false)
	public Articletype getArticletype() {
		return this.articletype;
	}

	public void setArticletype(Articletype articletype) {
		this.articletype = articletype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
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

	@Column(name = "summary", nullable = false, length = 100)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}