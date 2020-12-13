package com.book.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.book.dao.Scrapdao;
import com.book.model.Scrap;


@Controller
public class BookController {
	
	@Autowired
	Scrapdao scrapdao;
	
	@RequestMapping("/detail")
	public String addfriend()
	{
		return "detailfill";
	}  
	
	@RequestMapping("/")
	public ModelAndView listContact(ModelAndView model)
	{
		List<Scrap> lists=scrapdao.list();
		model.addObject("name", "nayana");
		model.addObject("listofrecords", lists);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView SaveContact(@ModelAttribute Scrap scrap)
	{
		
		if(scrap.getId() == 0)
		{
			scrapdao.save(scrap);
		}
		else
		{
			scrapdao.update(scrap);
		}
		return new ModelAndView("redirect:/");
	}


	@RequestMapping("/edit")
	public ModelAndView EditContact(HttpServletRequest request)
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		Scrap s= scrapdao.get(id);
		ModelAndView model= new ModelAndView();
		model.addObject("records", s );
		model.setViewName("detailfill");
		//contactdao.save(contact);
		return model;
	}

	@RequestMapping("/delete")
	public ModelAndView DeleteContact(@RequestParam Integer id)
	{
		scrapdao.delete(id);
		return new ModelAndView("redirect:/");
	}
	


}
