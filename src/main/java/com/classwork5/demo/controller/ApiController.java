package com.classwork5.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.classwork5.demo.model.Book;
import com.classwork5.demo.service.ApiService;


@RestController
public class ApiController {
@Autowired
ApiService eser;
	@PostMapping("addn")//adding n details
	public List<Book> addnstudents(@RequestBody List<Book> ee) {
		return eser.saveninfo(ee);
	}
	@GetMapping("disp")
	public List<Book> show(){
		return eser.showinfo();
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Book>showDetail(@PathVariable int id) {
	    Book book = eser.getStudentById(id);
	    
	    if (book != null) {
	        return new ResponseEntity<>(book, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Book ee) {
		return eser.updateinfobyid(id,ee);
	}
	@DeleteMapping("delpar")//RequestParam
	public String deleteparid(@RequestParam int id) {
		eser.deleteid(id);
		return "id deleted";
	}
}
