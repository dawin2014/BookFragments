package com.example.chalmers.bookfragments;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Sophia on 9/3/2017.
 * add "initData(){call createBook}" in main class
 */

public class SimpleBookManager implements BookManagerInterface {
    public ArrayList<Book> booksArray = new ArrayList<>();
    DatabaseHelper myDb;

    @Override
    public Book createBook(String author, String title, int price, String isbn, String course) {
        Book bookObj = new Book(author, title, price, isbn, course);
        booksArray.add(bookObj);
        return bookObj;
    }
    @Override
    public ArrayList<Book> getAllBooks() {

            return booksArray;
    }
    @Override
    public int count() {
        return booksArray.size();
    }

    @Override
    public Book getBook(int index) {

        return booksArray.get(index);
    }
    @Override
    public void removeBook(Book book) {
        booksArray.remove(book);
    }

    @Override
    public void moveBook(int from, int to) {

    }

    @Override
    public int getMinPrice() {

        double minValue = booksArray.get(0).getPrice() ;
        int indexOfMinValue = 0;
        for(int i = 0; i < booksArray.size(); i++){
            if(booksArray.get(i).getPrice() < minValue){
                indexOfMinValue = i;
            }
        }
        return booksArray.get(indexOfMinValue).getPrice();
    }

    @Override
    public int getMaxPrice() {

        double maxValue = booksArray.get(0).getPrice() ;
        int indexOfMaxValue = -1;
        for(int i = 0; i < booksArray.size(); i++){
            if(booksArray.get(i).getPrice() > maxValue){
                indexOfMaxValue = i;
            }
        }
        return booksArray.get(indexOfMaxValue).getPrice();
    }

    @Override
    public int getTotalCost() {
        int totalPrice = 0;
        for (int i = 0; i < booksArray.size(); i++) {
            totalPrice += booksArray.get(i).getPrice();
        }
        return totalPrice;
    }

    @Override
    public float getMeanPrice() {
        return (getTotalCost()/booksArray.size());
    }

    @Override
    public boolean saveChanges(Book book, Context context) {
//        boolean res;
//        int resSum = 0;
//        for(int i=0; i<count();i++){
//            res = myDb.insertData(booksArray.get(i).getAuthor(),
//                    booksArray.get(i).getTitle(),
//                    booksArray.get(i).getPrice(),
//                    booksArray.get(i).getIsbn(),
//                    booksArray.get(i).getCourse());
//            if(res==true)
//                resSum++;
//        }
//        if (resSum==count())
//            return true;
//        else
            return false;
    }
}
