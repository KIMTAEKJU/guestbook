package com.douzone.guestbook3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook3.dao.GuestBookDao;
import com.douzone.guestbook3.vo.GuestBookVo;

@Controller

public class GuestbookController 
{
	@Autowired
	private GuestBookDao guestbookDao;
	
	@RequestMapping({"", "/list"})
	public String list(Model model)
	{
		System.out.println("여기1");
		model.addAttribute("list", guestbookDao.getList());
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(GuestBookVo vo)
	{
		System.out.println("여기");
		guestbookDao.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteform()
	{
		return "deleteform";
	}
	
	@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
	public String delete(GuestBookVo vo)
	{
		guestbookDao.delete(vo);
		return "redirect:/";
	}
	
	
}
