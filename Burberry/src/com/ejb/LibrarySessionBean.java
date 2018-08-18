package com.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
 
@Stateless
public class LibrarySessionBean implements LibrarySessionBeanLocal {
   
   List<String> bookShelf;    
   
   public LibrarySessionBean(){
	  System.out.println("Injector called this constructor"); 
	   
      bookShelf = new ArrayList<String>();
   }
    
   public void addBook(String bookName) {
      bookShelf.add(bookName);
   }    
 
   public List<String> getBooks() {
      return bookShelf;
   }
}