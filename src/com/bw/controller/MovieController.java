package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.bean.Movie;
import com.bw.bean.Types;
import com.bw.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping("list")
	public String getList(Model m,String mname,String types,@RequestParam(defaultValue="1")int PageNum) {
		int PageSize = 3;
		int StartPage =(PageNum-1)*PageSize;
		int count = service.getCount();
		int totalPage = (count/PageSize)+(count%PageSize==0?0:1);
		
		List list = service.getList(mname,types,StartPage,PageSize);
		List type = service.getTypes();
		m.addAttribute("type", type);
		m.addAttribute("list", list);
		m.addAttribute("mname", mname);
		m.addAttribute("types", types);
		m.addAttribute("PageNum",PageNum );
		m.addAttribute("totalPage",totalPage);
		return "list";
	}
	
	
	@RequestMapping("delete")
	@ResponseBody
	public boolean delete(String mid) {
		try {
			service.delete(mid);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("toAdd")
	public String toAdd(Model m) {
		List list = service.toAdd();
		m.addAttribute("list", list);
		return "add";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public Object add(Movie m,int[] tids) {
		try {
			service.add(m,tids);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("upd")
	public String upd(Model m) {
		List list = service.toAdd();
		m.addAttribute("list", list);
		return "update2";
	}
	
	@RequestMapping("getById")
	@ResponseBody
	public Object getById(int mid) {
		Movie movie = service.MovieId(mid);
		List list = service.CentersId(mid);
		Map map = new HashMap();
		map.put("movie", movie);
		map.put("list", list);
		return map;
	}
	@RequestMapping("update")
	@ResponseBody
	public Object update(Movie m,int[] tids) {
		try {
			service.update(m,tids);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
