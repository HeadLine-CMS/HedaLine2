package mashen.model;

import com.mysql.fabric.xmlrpc.base.Data;

public class Article {
	
	private int id;
	private int count;
	private String title;
	private String content;
	private String headName;
	private String titleImg;
	private String headImg;
	private String genre;
	private Data created;
	private int check;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public Data getCreated() {
		return created;
	}
	public void setCreated(Data created) {
		this.created = created;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", count=" + count + ", title=" + title + ", content=" + content + ", headName="
				+ headName + ", titleImg=" + titleImg + ", headImg=" + headImg + ", genre=" + genre + ", created="
				+ created + ", check=" + check + "]";
	}
	
	
	
	
}
