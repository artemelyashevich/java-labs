package com.elyashevich.book.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Book {

    private Integer id;

    private String title;

    private Set<String> authors = new HashSet<>();

    private String publisher;

    private LocalDate publishedDate;

    private Long pages;

    private Double price;

    private BindingType bindingType;

    public Book() {}

    public Book(Integer id, String title, Set<String> authors, String publisher, LocalDate publishedDate, Long pages, Double price, BindingType bindingType) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.pages = pages;
        this.price = price;
        this.bindingType = bindingType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BindingType getBindingType() {
        return bindingType;
    }

    public void setBindingType(BindingType bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && pages == book.pages && Double.compare(price, book.price) == 0 && Objects.equals(title, book.title) && Objects.equals(authors, book.authors) && Objects.equals(publisher, book.publisher) && Objects.equals(publishedDate, book.publishedDate) && bindingType == book.bindingType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, publisher, publishedDate, pages, price, bindingType);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", authors=").append(authors);
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", publishedDate=").append(publishedDate);
        sb.append(", pages=").append(pages);
        sb.append(", price=").append(price);
        sb.append(", bindingType=").append(bindingType);
        sb.append('}');
        return sb.toString();
    }
}
