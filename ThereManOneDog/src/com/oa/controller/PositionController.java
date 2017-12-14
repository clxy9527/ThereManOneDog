package com.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	modelAndView.setViewName("");
	return modelAndView;
}
@RequestMapping("/deleteposition")
public ModelAndView deleteposition(HttpServletRequest request,HttpServletResponse response,Position position){
	int pId=0;
	int dId=0;
	ModelAndView modelAndView =new ModelAndView();
	positionService.deleteposition(pId,dId);
	modelAndView.addObject("position",position);
	modelAndView.setViewName("");
	return modelAndView;
}

@RequestMapping("/queryposition")
public ModelAndView queryposition(HttpServletRequest request,HttpServletResponse response,Position position,int dId){
	ModelAndView modelAndView =new ModelAndView();
	position.setdId(dId);
	List<Position> positionlist  =positionService.queryposition(dId);
	modelAndView.addObject("positionlist",positionlist);
	modelAndView.setViewName("AddStaff");
	return modelAndView;
}
}
