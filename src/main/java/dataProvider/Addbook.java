package dataProvider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Addbook {
    private String name;
    private int isbn;
    private String aisle;
    private  String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Addbook AddBookdata(String name, int isbn, String aisle, String author) throws JsonProcessingException {


        Addbook AddBookdata=new Addbook();

        AddBookdata.setName(name);
        AddBookdata.setIsbn(isbn);
        AddBookdata.setAisle(aisle);
        AddBookdata.setAuthor(author);


        ObjectMapper mapper=new ObjectMapper();


        String bookdata=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(AddBookdata);

        return AddBookdata;

    }




}
