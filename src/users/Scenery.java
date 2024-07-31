package users;

import java.util.List;

public class Scenery {
	private String belongcity;
	private String name;
	private String brief;
	private String imgpath;
	private List<String> type;
	private int visittimes;
	public Scenery() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public String getBelongcity() {
		return belongcity;
	}
	public void setBelongcity(String belongcity) {
		this.belongcity = belongcity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String Imgpath) {
		this.imgpath = Imgpath;
	}
	public List<String> getType() {
		return type;
	}
	public void setType(List<String> list) {
		this.type = list;
	}
	public int getVisittimes() {
		return visittimes;
	}
	public void setVisittimes(int visittimes) {
		this.visittimes = visittimes;
	}

}
