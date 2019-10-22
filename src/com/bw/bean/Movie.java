package com.bw.bean;

import java.util.List;

public class Movie {
	private Integer mid;
	private String mname;
	private Integer price;
	private String type;
	private String dtime;
	private List<Types> types;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(Integer mid, String mname, Integer price, String type, String dtime, List<Types> types) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.price = price;
		this.type = type;
		this.dtime = dtime;
		this.types = types;
	}
	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", mname=" + mname + ", price=" + price + ", type=" + type + ", dtime=" + dtime
				+ "]";
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public List<Types> getTypes() {
		return types;
	}
	public void setTypes(List<Types> types) {
		this.types = types;
	}
	
	
}
