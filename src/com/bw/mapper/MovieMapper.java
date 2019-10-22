package com.bw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.bean.Movie;

public interface MovieMapper {

	List getList(@Param("mname")String mname,@Param("types")String types,@Param("StartPage") int StartPage,@Param("PageSize") int PageSize);

	List getTypes();

	int getCount();

	void delMovie(@Param("mid") String mid);

	void delCenter(@Param("mid") String mid);

	List toAdd();

	void addMovie(Movie m);

	void addCenters(@Param("tid")int tid,@Param("mid") int mid);

	Movie MovieId(@Param("mid")int mid);

	List CentersId(@Param("mid")int mid);

	void deleteCenters(@Param("mid")Integer mid);

	void updatetMovie(Movie m);
}
