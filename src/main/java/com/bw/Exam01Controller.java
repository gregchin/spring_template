package com.bw;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class Exam01Controller {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/index")
	  public String index(Model model) {
	    

	    return "index";
	  }
	@GetMapping("/page01")
	  public String toPage01(Model model) {
	    

	    return "page01";
	  }
	
	@GetMapping("/page02")
	  public String toPage02(Model model) {
	    

	    return "page02";
	  }
	
	@GetMapping("/page03")
	  public String toPage03Index(Model model) {
	    

	    return "page03";
	  }
	
	@GetMapping("/page03/all")
	  public @ResponseBody JSONObject toPage03() {
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		Employee employee;
		
		List list = employeeService.getAllEmployees();
		for (int i=0; i< list.size();i++) {
			employee = (Employee)list.get(i);
			List list1 = new ArrayList();
			list1.add(employee.getId());
			list1.add(employee.getName());
			list1.add(employee.getPosition());
			list1.add(employee.getOffice());
			list1.add(employee.getExtn());
			list1.add(employee.getSdate());
			list1.add(employee.getSalary());
			array.add(list1);
			
		}
		
		obj.put("data", array);

	    return obj;
	  }
	
	@GetMapping("/page03/two")
	  public @ResponseBody JSONObject toPage03Two() {
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		Employee employee;
		
		List list = employeeService.getAllEmployees();
		for (int i=0; i< 1;i++) {
			employee = (Employee)list.get(i);
			List list1 = new ArrayList();
			list1.add(employee.getId());
			list1.add(employee.getName());
			list1.add(employee.getPosition());
			list1.add(employee.getOffice());
			list1.add(employee.getExtn());
			list1.add(employee.getSdate());
			list1.add(employee.getSalary());
			array.add(list1);
			
		}
		
		obj.put("data", array);

	    return obj;
	  }
	
	@GetMapping("/page04")
	  public String toPage04Index(Model model) {
	    

	    return "page04";
	  }
	
	@GetMapping(value="/page04/query")
	public @ResponseBody JSONObject toPage04Query(@RequestParam("empname") String empname, Model model){
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
        List list = new ArrayList();
		Employee employee;
		System.out.println(empname);
		if (empname.equals("")) {
		list = employeeService.getAllEmployees();
		
		} else {
			list = employeeService.getEmployeeByName(empname);
		}
		for (int i=0; i< list.size();i++) {
			employee = (Employee)list.get(i);
			List list1 = new ArrayList();
			list1.add(employee.getId());
			list1.add(employee.getName());
			list1.add(employee.getPosition());
			list1.add(employee.getOffice());
			list1.add(employee.getExtn());
			list1.add(employee.getSdate());
			list1.add(employee.getSalary());
			array.add(list1);
			
		}
		
		obj.put("data", array);
		return obj;
	}
	
	@GetMapping(value="/rejson")
	public @ResponseBody JSONObject reJSON() {
		
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		List list1 = new ArrayList();
		list1.add("1");
		list1.add("aaa");
		list1.add("100");
		list1.add("100");
		list1.add("100");
		list1.add("2011/04/25");
		list1.add("100");
		
		
		
		array.add(list1);
		
		List list2 = new ArrayList();
		list2.add("2");
		list2.add("bbb");
		list2.add("200");
		list2.add("200");
		list2.add("200");
		list2.add("2022/04/25");
		list2.add("200");
		
		array.add(list2);
		obj.put("data", array);
	    
	    return obj;
	}
	
	@RequestMapping(value = "/pojson", method = RequestMethod.POST) 
    public String poJSON(@RequestBody JSONObject obj,Model model) { 
		List jsonArray = (List) obj.get("mydata");
		List list1;
		System.out.println(jsonArray.isEmpty());
		Iterator iterator = jsonArray.iterator();
		while(iterator.hasNext()) {
			list1 = (ArrayList)iterator.next();
			System.out.println(list1);
			for (int i=0; i<list1.size(); i++) {
				System.out.println(list1.get(i));
			}
		}
		
		return "redirect:/index";
    } 
	
	@RequestMapping(value = "/page04/deleteMulti", method = RequestMethod.POST) 
    public @ResponseBody JSONObject toPage04DeleteMulti(@RequestBody JSONObject obj,Model model) { 
		JSONObject obj1 = new JSONObject();
		List jsonArray = (List) obj.get("mydata");
		Iterator iterator = jsonArray.iterator();
		
		while(iterator.hasNext()) {
			int empid = ((Integer)iterator.next()).intValue();
			employeeService.deleteEmployee(empid);
		}	
		return obj;
    } 
	
	@GetMapping(value = "/js") 
    public String js(Model model) { 
		
		return "js";
    } 
	
}
