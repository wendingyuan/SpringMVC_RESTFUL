package com.dsp.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Scope("prototype")
@Controller
@RequestMapping("/products")
public class TestController{
  
	/**
	 * 测试方法,HelloWord
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	*/
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getProducts(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setAttribute("name", "helloWord");
		return "products/list";
	}
/*
	@RequestMapping(value="/info/{proId}",method=RequestMethod.GET)
    public String getProductInfo(@PathVariable String proId, HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setAttribute("name", proId);
		return "products/list";
    }
*/
	@RequestMapping(value="/submit",method=RequestMethod.GET)
	public String submitProducts(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "products/submit";
	}
	
	@RequestMapping(value="/info",method=RequestMethod.POST)
    public String insertProduct(Product pro, HttpServletRequest request,HttpServletResponse response) throws Exception {
   
        request.setAttribute("name", pro.getPid()+"___"+pro.getPname());
         
        return "products/list";
    }

	@RequestMapping(value={"/info/{pid}"},method=RequestMethod.GET)
	public ModelAndView getProductInfo(@PathVariable String pid, HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
	
		Product pro = new Product();
		pro.setPid(pid);
		map.put("name", pid);
		map.put("pro", pro);
		ModelAndView mav=new ModelAndView("products/list",map);
		return mav;
	}
}