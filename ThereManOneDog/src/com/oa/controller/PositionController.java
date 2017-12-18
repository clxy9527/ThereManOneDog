package com.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.oa.pojo.Position;
import com.oa.service.impl.PositionService;

@Controller
@RequestMapping("/positionController")
public class PositionController {
@Autowired
private PositionService positionService;


@RequestMapping("/addposition")
public ModelAndView addedepartment(HttpServletRequest request,HttpServletResponse response,Position position){
	ModelAndView modelAndView =new ModelAndView();
	positionService.addposition(position);
	modelAndView.addObject("position",position);
	modelAndView.setViewName("index");
	return modelAndView;
}
@RequestMapping("/deleteposition")
public ModelAndView deleteposition(HttpServletRequest request,HttpServletResponse response,Position position){
	int pId=0;
	int dId=0;
	ModelAndView modelAndView =new ModelAndView();
	positionService.deleteposition(pId,dId);
	modelAndView.addObject("position",position);
	modelAndView.setViewName("index");
	return modelAndView;
}

@RequestMapping("/queryposition")
public void  queryposition(HttpServletRequest request,HttpServletResponse response,Position position,int dId) throws IOException{
	position.setdId(dId);
	List<Position> positionlist  =positionService.queryposition(dId);
	Gson gson=new Gson();
	String json=null;
	json=gson.toJson(positionlist);
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
	out.println(json);
}
}
