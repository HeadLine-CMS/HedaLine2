package mashen.model;

import java.util.Date;

public class User {
	private int id;
	private String headaccount;
	private String headpassword;
	private String headname;
	private String headimg;
	private String email;
	private Date created;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeadaccount() {
		return headaccount;
	}

	public void setHeadaccount(String headaccount) {
		this.headaccount = headaccount;
	}

	public String getHeadpassword() {
		return headpassword;
	}

	public void setHeadpassword(String headpassword) {
		this.headpassword = headpassword;
	}

	public String getHeadname() {
		return headname;
	}

	public void setHeadname(String headname) {
		this.headname = headname;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", headaccount=" + headaccount + ", headpassword=" + headpassword + ", headname="
				+ headname + ", headimg=" + headimg + ", email=" + email + ", created=" + created + "]";
	}

}
