/**
 * @author     Bernardo Ferrari
 * @implNote   Implementação da classe Library (DB) e seus atributos e métodos
 * */
package impl;

import java.util.ArrayList;

public class Library{
    private ArrayList<Book> books;
    public Library(){
        this.books = new ArrayList<>();
    }
    public LibStatus addBook(Book book){
        if(book.emptyAuthor())
            return LibStatus.EMPTYAUTHOR;
        if(book.emptyTitle())
            return LibStatus.EMPTYTITLE;
        if(this.searchBook(book.getTitle())[0] != -1)
            return LibStatus.DUPLICATED;
        books.add(book);
        return LibStatus.SUCCESS;
    }

    public LibStatus removeBook(Book book){
        Integer[] pair = this.searchBook(book.getTitle());
        if(pair[0] == -1)
            return LibStatus.NULL;
        books.remove(book);
        return LibStatus.REMOVED;
    }

    @Override
    public String toString(){
        String temp = books.isEmpty() ? "\nO acervo está vazio!" : "\nLivros disponíveis no acervo:\n";
        for(Book book : books){
            temp += "\n\nTítulo: " + book.getTitle() + "\nAutor: " + book.getAuthor() +
                    "\nAno de lançamento: " + book.getYear() + "\nNúmero de páginas: " + book.getNpages();
        }
        return temp;
    }
    public Integer[] searchBook(String booktitle){
        Integer[] pair = new Integer[2];
        pair[0] = -1; pair[1] = -1;
        for(Book book : books){
            if(book.getTitle().equals(booktitle)){
                pair[0] = 1; pair[1] = books.indexOf(book);
                return pair;
            }
        }
        return pair;
    }

    public Book getBookByIndex(Integer index){
        return this.books.get(index);
    }
}
