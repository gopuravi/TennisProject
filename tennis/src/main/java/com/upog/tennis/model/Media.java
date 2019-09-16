package com.upog.tennis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURT_TYPE")
public class Media {

	@Id 
	@Column(name = "MEDIA_INTERNAL_ID")
	int id;
	 
	@Column(name = "MEDIA_ID")
	int mediaId;
	@Column(name = "IMG_LINK")
	String imgLink;
	@Column(name = "VIDEO_LINK")
	String vidoeLink;
	@Column(name = "COMMENTS")
	String comments;


	public Media() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMediaId() {
		return mediaId;
	}


	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}


	public String getImgLink() {
		return imgLink;
	}


	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}


	public String getVidoeLink() {
		return vidoeLink;
	}


	public void setVidoeLink(String vidoeLink) {
		this.vidoeLink = vidoeLink;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Media [id=" + id + ", mediaId=" + mediaId + ", imgLink=" + imgLink + ", vidoeLink=" + vidoeLink
				+ ", comments=" + comments + "]";
	}
	
	
	
}
