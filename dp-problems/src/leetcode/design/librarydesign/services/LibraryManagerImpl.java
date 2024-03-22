package leetcode.design.librarydesign.services;

import leetcode.design.librarydesign.entity.Books;
import leetcode.design.librarydesign.entity.Library;

public class LibraryManagerImpl implements LibraryManager{
    private final Library library;
    public LibraryManagerImpl(final Library library) {
        this.library = library;
    }
    @Override
    public void addBook(Books book) {
        library.getBooks().add(book);
    }

    @Override
    public void removeBook(Books book) {
        library.getBooks().remove(book);
    }
}
