package com.yaohoo.be.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaohoo.be.dao.entity.ActivityDO;
import com.yaohoo.be.dao.entity.ClassDO;
import com.yaohoo.be.dao.entity.InfoDO;
import com.yaohoo.be.dao.service.ActivityManager;
import com.yaohoo.be.dao.service.ClassManager;
import com.yaohoo.be.dao.service.InfoManager;
@Controller
public class NavController {
	
	@Resource
	private ActivityManager activityManager;
	@Resource
	private InfoManager infoManager;
	@Resource
	private ClassManager classManager;
	
	@RequestMapping("/toMain")
	public String toMainPage(){
		return "main";
	}
	
	@RequestMapping("/toLogin")
	public String toLoginPage(){
		return "login";
	}
	
	@RequestMapping("/toAddActivity")
	public String toAddActivityPage(){
		return "/activity/addActivity";
	}
	
	@RequestMapping("/toAddInfo")
	public String toAddInfoPage(){
		return "/info/addInfo";
	}
	
	@RequestMapping("/toAddClass")
	public String toAddClassPage(){
		return "/class/addClass";
	}
	
	@RequestMapping("/toManageActivity")
	public String toManageActivityPage(){
		return "/activity/activityList";
	}
	
	@RequestMapping("/toManageInfo")
	public String toManageInfoPage(){
		return "/info/infoList";
	}
	
	@RequestMapping("/toManageClass")
	public String toManageClassPage(){
		return "/class/classList";
	}
	
	@RequestMapping("/toEditActivity")
	public String toEditActivityPage(
			@RequestParam(required = true) int aId,
			@RequestParam(required = true) String subject,
			ModelMap modelMap){
		ActivityDO activityDO = activityManager.getActivityContent(aId);
		activityDO.setSubject(subject);
		modelMap.addAttribute("activityDO", activityDO);
		return "/activity/editActivity";
	}
	
	@RequestMapping("/toEditInfo")
	public String toEditInfoPage(
			@RequestParam(required = true) int iId,
			@RequestParam(required = true) String subject,
			ModelMap modelMap){
		InfoDO infoDO = infoManager.getInfoContent(iId);
		infoDO.setSubject(subject);
		modelMap.addAttribute("infoDO", infoDO);
		return "/info/editInfo";
	}
	
	@RequestMapping("/toEditClass")
	public String toEditClassPage(
			@RequestParam(required = true) int cId,
			@RequestParam(required = true) String subject,
			ModelMap modelMap){
		ClassDO classDO = classManager.getClassContent(cId);
		classDO.setSubject(subject);
		modelMap.addAttribute("classDO", classDO);
		return "/class/editClass";
	}
	
}
