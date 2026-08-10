package org.example.OOPTraining.AnimalOOPDemo;

public class Book implements LibraryItem {
    private String title;
    private String author;
    private int pages;
    public Book(String title, String author, int pages) {
        setTitle(title);
        setAuthor(author);
        setPages(pages);
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            IO.println("Name cannot be empty.");
        } else {
            this.title = title;
        }
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        } else {
            this.pages = 0;
            IO.println("Pages must be above 0");
        }
    }
    @Override
    public void printAllInfo() {
        IO.println(
                "Book: " + title +
                        " by " + author +
                        " (" + pages + " pages) [" +
                        getShelfCode() + "]"
        );
    }
    @Override
    public String getLabel() {
        return title;
    }
    @Override
    public String getShelfCode() {
        return "B-01";
    }
}

