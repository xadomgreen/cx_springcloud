package cn.com.xc.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 商品列表
 * 
 * @author Xadom Green
 *
 */
@Controller
public class PageController {

//	@Autowired
//	private ItemService itemService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String showIndex() {
		return "/index";
	}

	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
//	@RequestMapping("/item/list")
//	@ResponseBody
//	public EasyUIDataGridResult getItemList(Integer page ,Integer rows){
//		EasyUIDataGridResult result = itemService.getItemList(page,rows);
//		return result ;
//	}
}
