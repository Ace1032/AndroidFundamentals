package com.example.onlinelibary;

import java.util.ArrayList;



public class Util {

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadBooks;
    private static ArrayList<Book> wantsBooks;
    private static ArrayList<Book> alreadyReadBooks;

    public Util(){
        if (allBooks==null) {
            allBooks = new ArrayList<>();
            initAllBooks();
        }
        if(currentlyReadBooks==null)
            currentlyReadBooks=new ArrayList<>();
        if(wantsBooks==null)
            wantsBooks=new ArrayList<>();
        if(alreadyReadBooks==null)
            alreadyReadBooks=new ArrayList<>();
    }


    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public ArrayList<Book> getCurrentlyReadBooks() {
        return currentlyReadBooks;
    }

    public ArrayList<Book> getWantsBooks() {
        return wantsBooks;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }
    //add methods
    public boolean addCurrentlyReadBooks(Book book) {
        return currentlyReadBooks.add(book);
    }

    public boolean addWantsBooks(Book book){
        return wantsBooks.add(book);
    }
    public boolean addAlreadyReadBooks(Book book){
        return alreadyReadBooks.add(book);
    }
    //remove methods

    public boolean removeCurrentlyReadBooks(Book book) {
        return currentlyReadBooks.remove(book);
    }

    public boolean removeWantsBooks(Book book){
        return wantsBooks.remove(book);
    }
    public boolean removeAlreadyReadBooks(Book book){
        return alreadyReadBooks.remove(book);
    }
    private static void initAllBooks(){
        //https://www.goodreads.com/api/keys
        //key: yl6xfUFobRH1XHGF0vUzqw
        //secret: qiS73AM4ouTGcgaYxMb6C0sn1lXPsikjWgWNotK3Z0
        Book b=new Book("5MQFrgEACAAJ", "Harry Potter and the Sorcerer's Stone", "J. K. Rowling",
                455, "http://books.google.com/books/content?id=5MQFrgEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
                "Rescued from the outrageous neglect of his aunt and uncle, a young boy with a great destiny " +
                        "proves his worth while attending Hogwarts School for Witchcraft and Wizardry.");

        allBooks.add(b);

        //TODO:


    }
}
