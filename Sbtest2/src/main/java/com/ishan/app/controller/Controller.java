
package com.ishan.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ishan.app.entity.Employee;
import com.ishan.app.service.*;

@RestController
public class Controller {

	//private EmployeeService es= new EmployeeService();
	/*List<String> li = new ArrayList(Arrays.asList("a","b,"c"));
	li.
	 */
	@Autowired
	EmployeeService es;

	@RequestMapping("/hi")
	public String test(){
		return "hi";
	}

	@RequestMapping("/e")
	public List<Employee> e(){

		return es.getAll();
	}
	@RequestMapping("/e/{id}")
	public Employee gete(@PathVariable Long id){

		return es.getE(id);
	}

	@RequestMapping(method = RequestMethod.POST ,value="/e")
	public ResponseEntity<String> addE(@RequestBody Employee e){

		es.addE(e);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	@RequestMapping(method = RequestMethod.PUT ,value="/e/up/{id}")
	public ResponseEntity updateE(@RequestBody Employee e, @PathVariable Long id){

		es.update(id, e);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE ,value="/e/del/{id}")
	public ResponseEntity del(@PathVariable Long id){

		es.del(id);
		return new ResponseEntity(HttpStatus.OK);
	}






}
