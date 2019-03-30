package com.school.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.pojo.ItemsCustom;
import com.school.pojo.ItemsQueryVo;
import com.school.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		
		List<ItemsCustom> itemsList =  itemsService.findItemsList(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");;
		return modelAndView;
		
	}
	
//	@RequestMapping("/editItem")
//	public ModelAndView editItem() throws Exception {
//		
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("itemsCustom",itemsCustom);
//		modelAndView.setViewName("items/editItem");
//		
//		return modelAndView;
//		
//	}
	
	
//	@RequestMapping("/editItemSubmit")
//	public ModelAndView editItemSubmit() throws Exception {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("success");
//		
//		return modelAndView;
//		
//	}
	
	
	@RequestMapping("/editItem")
	public String editItem(Model model,Integer id) throws Exception {
		
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		model.addAttribute("itemsCustom",itemsCustom);
		
		return "items/editItem";
		
	}
	
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(Integer id, ItemsQueryVo itemsQueryVo) throws Exception {
		
		
		System.out.println("------------------------");
//		itemsService.updateItems(id, itemsCustom);
		System.out.println("------------------------");
		
		return "success";
		
	}
	
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] item_id) throws Exception {
		
		
		return "success";
	}
	
}
