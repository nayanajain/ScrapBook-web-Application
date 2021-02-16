package com.book.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.book.Config.ScrapexcelExport;
import com.book.Config.ScrappdfExport;
import com.book.Service.ScrapService;
import com.book.model.Scrap;
//import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.lowagie.text.DocumentException;


@Controller
public class BookController {
	
	@Autowired
	private ScrapService scrapService;
	
	@RequestMapping("/detail")
	public String addfriend(Model model)
	{
		Scrap s=new Scrap();
		//List<Scrap> lists=scrapService.list();
		//model.addObject("name", "nj");
		model.addAttribute("listofrecords", s);
		
		return "detailfill";
	}  
	
	@GetMapping("/")
	public String listContact(Model model)
	{
		List<Scrap> lists=scrapService.list();
		//model.addObject("name", "nj");
		model.addAttribute("listofrecords", lists);
	
		return "index";
	}
	
	
	
	@RequestMapping("/createpdf")
	public void createpdf(HttpServletRequest request, HttpServletResponse response) throws DocumentException, IOException
	{
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=users.pdf");
		List<Scrap> lists=scrapService.list();
		ScrappdfExport scrappdfExport=new ScrappdfExport(lists);
		scrappdfExport.export(lists,response);
	}   
	
	
	@RequestMapping("/createexcel")
	public void createexcel(HttpServletRequest request, HttpServletResponse response) throws DocumentException, IOException
	{
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=users.xlsx");
		List<Scrap> lists=scrapService.list();
		ScrapexcelExport scrapexcelExport=new ScrapexcelExport(lists);
		scrapexcelExport.export(lists,response);
	
	}


@RequestMapping(value="/save")
	public ModelAndView SaveContact(@ModelAttribute Scrap scrap)
	{
		if(scrap.getId() == 0)
		{
			scrapService.save(scrap);
		}
		else
		{
			scrapService.update(scrap);
		}
		return new ModelAndView("redirect:/");
	} 
	
	
	@GetMapping("/edit")
	public String EditContact(@RequestParam("id")int id, Model model)
	{
		System.out.println("poiuytrtyhjhgf");
		Scrap s= scrapService.get(id);
		System.out.println(s.getId()+""+s.getName()+""+s.getRel());
		model.addAttribute("listofrecords", s);
		System.out.println(s.getId()+s.getName());
		return "detailfill";

	}


	@RequestMapping("/delete")
	public ModelAndView DeleteContact(@RequestParam Integer id)
	{
		scrapService.delete(id);
		return new ModelAndView("redirect:/");
	}
	


}
