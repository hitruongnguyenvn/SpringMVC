package com.unknown.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unknown.model.News;
import com.unknown.paging.IPageable;
import com.unknown.paging.PageRequest;
import com.unknown.service.INewsService;

@Controller(value = "newsAdmin")
public class NewsController {

	@Autowired
	private INewsService newsService;

	@RequestMapping(value = "/admin/news/list", method = RequestMethod.GET)
	public ModelAndView showAll(@ModelAttribute("model") News news) {
		ModelAndView modelAndView = new ModelAndView("admin/news/list");
		IPageable pageable = new PageRequest(news.getPage(), news.getMaxPageItem(), null);
		int totalItem = newsService.getTotalItem();
		Integer totalPage = (int) Math.ceil((double) totalItem / pageable.getFetchNextRows());
		news.setTotalPage(totalPage);
		news.setModels(newsService.findAll(pageable));
		modelAndView.addObject("model", news);
		return modelAndView;
	}
}
