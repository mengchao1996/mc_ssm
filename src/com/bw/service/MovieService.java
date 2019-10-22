package com.bw.service;

import java.util.List;

import org.springframework.ui.Model;

import com.bw.bean.Movie;


public interface MovieService {

	List getList(String mname, String types, int startPage, int pageSize);

	List getTypes();

	int getCount();

	void delete(String mid);

	List toAdd();

	void add(Movie m, int[] tids);

	Movie MovieId(int mid);

	List CentersId(int mid);

	void update(Movie m, int[] tids);


}
