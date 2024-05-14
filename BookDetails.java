/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showbook.dto;

public class BookDetails {

    public String getBookname() {
        return bookname;
    }

    public String getBookwriter() {
        return bookwriter;
    }

    public double getBookprice() {
        return bookprice;
    }

    public BookDetails(String bookname, String bookwriter, double bookprice) {
        this.bookname = bookname;
        this.bookwriter = bookwriter;
        this.bookprice = bookprice;
    }
    
    private String bookname;
    private String bookwriter;
    private double bookprice;
}

