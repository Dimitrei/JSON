package com.nazi.dimitrei.Author.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nazi.dimitrei.Author.models.Author;
import com.nazi.dimitrei.Author.services.AuthorService;

@CrossOrigin
@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping(value="/filePathCvs", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Author> addAuthors(@RequestParam("filePathCsv") String filePathCsv) {
		return authorService.addAuthors(filePathCsv);
	}
}
