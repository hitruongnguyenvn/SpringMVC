package com.unknown.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "News")
public class NewsEntity extends BaseEntity {
	
	@Column(name = "title", columnDefinition = "NVARCHAR(255)")
	private String title;
	
	@Column(name = "thumbnail", columnDefinition = "NVARCHAR(255)")
	private String thumbnail;
	
	@Column(name = "shortDescription", columnDefinition = "NVARCHAR(255)")
	private String shortDescription ;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content ;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
