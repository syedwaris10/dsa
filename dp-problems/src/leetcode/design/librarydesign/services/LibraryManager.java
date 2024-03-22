package leetcode.design.librarydesign.services;

import leetcode.design.librarydesign.entity.Books;

public interface LibraryManager {
    public void addBook(Books book);
    public void removeBook(Books book);

}
