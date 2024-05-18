/**
 * @author     Bernardo Ferrari
 * @implNote   Implementação da classe Book (livro) e seus atributos e métodos
 * */
package impl;

import java.util.Objects;

public class Book{
    private String title;
    private String author;
    private Integer year;
    private Integer npages;

    public Book(){}

    public Book(String title, String author, Integer year, Integer npages){
        this.title = title;
        this.author = author;
        this.year = year;
        this.npages = npages;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public Integer getYear(){
        return this.year;
    }

    public void setYear(Integer year){
        this.year = year;
    }

    public Integer getNpages(){
        return this.npages;
    }

    public void setNpages(Integer npages) {
        this.npages = npages;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Book book = (Book)o;
        return Objects.equals(this.title, book.title);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.title, this.author, this.year, this.npages);
    }

    public Boolean emptyAuthor(){
        return this.author.isEmpty();
    }

    public Boolean emptyTitle(){
        return this.title.isEmpty();
    }
}
