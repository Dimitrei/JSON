package com.nazi.dimitrei.Author.services;

import java.util.List;

import com.nazi.dimitrei.Author.models.Author;

public interface AuthorService {

	public List<Author> addAuthors(String filePathCsv);
	public void findCvsFile(String filePathCsv, List<Author> authorListCsv);
	public void findJsonFile(List<Author> authorListJson);
	public void combineLists(List<Author> authorListFile, List<Author> authorListJson);
	public void writeToFile(List<Author> authorListJson);
}
