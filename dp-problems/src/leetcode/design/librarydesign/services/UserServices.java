package leetcode.design.librarydesign.services;

import leetcode.design.librarydesign.entity.Books;

public interface UserServices {
    public void returnBook(Books book);
    public void borrowBook(Books book);
}
