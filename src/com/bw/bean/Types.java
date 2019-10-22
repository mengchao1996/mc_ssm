package com.bw.bean;

import java.util.List;

public class Types {
	private Integer tid;
	private String tname;
	private List<Movie> movie;
	public Types() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Types(Integer tid, String tname, List<Movie> movie) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.movie = movie;
	}
	@Override
	public String toString() {
		return "Types [tid=" + tid + ", tname=" + tname + ", movie=" + movie + "]";
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public List<Movie> getMovie() {
		return movie;
	}
	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	
	
}
