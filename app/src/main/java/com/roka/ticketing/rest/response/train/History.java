package com.roka.ticketing.rest.response.train;

public class History {

    private int id;
    private String gdsBook;
    private String bookInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGdsBook() {
        return gdsBook;
    }

    public void setGdsBook(String gdsBook) {
        this.gdsBook = gdsBook;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }
}
