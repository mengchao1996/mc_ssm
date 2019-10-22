package com.bw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bw.bean.Movie;
import com.bw.bean.Types;
import com.bw.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieMapper mapper;

	@Override
	public List getTypes() {
		// TODO Auto-generated method stub
		return mapper.getTypes();
	}

	@Override
	public List getList(String mname, String types,int StartPage, int PageSize) {
		// TODO Auto-generated method stub
		return mapper.getList(mname, types,StartPage,PageSize);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mapper.getCount();
	}

	@Override
	public void delete(String mid) {
		// TODO Auto-generated method stub
		mapper.delMovie(mid);
		mapper.delCenter(mid);
	}

	@Override
	public List toAdd() {
		// TODO Auto-generated method stub
		return mapper.toAdd();
	}

	@Override
	public void add(Movie m, int[] tids) {
		// TODO Auto-generated method stub
		mapper.addMovie(m);
		if(tids!=null) {
			for (int tid : tids) {
				mapper.addCenters(m.getMid(),tid);
			}
		}
		
	}

	@Override
	public Movie MovieId(int mid) {
		// TODO Auto-generated method stub
		return mapper.MovieId(mid);
	}

	@Override
	public List CentersId(int mid) {
		// TODO Auto-generated method stub
		return mapper.CentersId(mid);
	}

	@Override
	public void update(Movie m, int[] tids) {
		// TODO Auto-generated method stub
		mapper.updatetMovie(m);
		mapper.deleteCenters(m.getMid());
		if(tids!= null) {
			for (int tid : tids) {
				mapper.addCenters(m.getMid(),tid);
			}
		}
	}
	
	
	
}
