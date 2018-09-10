package com.nazi.dimitrei.Author.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nazi.dimitrei.Author.models.Author;
import com.nazi.dimitrei.Author.models.AuthorTypes;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	final private String filePathJson = "C:\\Developer\\workspace\\Author\\Author\\src\\main\\resources\\secDivAuthors.json";
	
	@Override
	public List<Author> addAuthors(String filePathCsv) {
		
		List<Author> authorListCsv = new ArrayList<Author>();
		List<Author> authorListJson = new ArrayList<Author>();
		
		findCvsFile(filePathCsv, authorListCsv);
		findJsonFile(authorListJson);
		combineLists(authorListCsv, authorListJson);
		writeToFile(authorListJson);
		
		return authorListJson;
	}
	
	@Override
	public void findCvsFile(String filePathCsv, List<Author> authorListCsv) {
		
		String line = "";
		String cvsSplit = "|";
		int key = 1;
		List<String> authorList;
		AuthorTypes authorTypes;
		Author author;
		
		try (BufferedReader br =  new BufferedReader(new FileReader(filePathCsv))) {
			
			while((line = br.readLine()) != null) {
				
				authorList = Arrays.asList(line.split(Pattern.quote(cvsSplit)));
				
				authorTypes = new AuthorTypes(authorList.get(2), authorList.get(3));
				
				author = new Author(String.valueOf(key), authorList.get(0), authorList.get(1), authorTypes, authorList.get(4));
				
				authorListCsv.add(author);
							
				key++;
			}
		} catch (FileNotFoundException  fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
            ioe.printStackTrace();
        }
	}
	
	@Override
	public void findJsonFile(List<Author> authorListJson) {
		
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	TypeReference<List<Author>> mapType = new TypeReference<List<Author>>() {};
    	
    	try {
    		authorListJson.addAll(objectMapper.readValue(new File(filePathJson), mapType));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public void combineLists(List<Author> authorListCsv, List<Author> authorListJson) {
		
		int authorListJsonSize = authorListJson.size();
		
		for (Author author : authorListCsv) {
			author.setKey(String.valueOf(++authorListJsonSize));
			authorListJson.add(author);
		}
	}
	
	@Override
	public void writeToFile(List<Author> authorListJson) {
		
		ObjectMapper objectMapper = new ObjectMapper();

	    try {  
	    	objectMapper.writeValue(new File(filePathJson),  authorListJson);
	    } catch (IOException ioe) {  
	        ioe.printStackTrace();  
	    }  
	}
}
