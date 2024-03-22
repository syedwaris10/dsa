package leetcode.design.librarydesign.services;

import leetcode.design.librarydesign.entity.Books;
import leetcode.design.librarydesign.entity.Users;

public class UserServicesImpl implements UserServices{
    private final Users users;

    public UserServicesImpl(final Users users) {
        this.users = users;
    }
    @Override
    public void returnBook(final Books book) {
        users.getReturnedBook().add(book);
        users.getIssuedBook().remove(book);
    }

    @Override
    public void borrowBook(final Books book) {
        users.getIssuedBook().add(book);
    }
}
