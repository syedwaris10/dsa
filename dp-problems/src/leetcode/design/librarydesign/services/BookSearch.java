package leetcode.design.librarydesign.services;

import leetcode.design.librarydesign.entity.Books;
import leetcode.design.librarydesign.entity.Library;

import java.util.Set;
import java.util.stream.Collectors;

public class BookSearch implements BookSearchEngine{
    private final Library library;

    public BookSearch (Library library) {
        this.library = library;
    }
    @Override
    public Set<Books> searchBook(String search) {
        Set<Books> result = library.getBooks().stream().filter(book -> {
            return book.getBookTitle().equals(search) || book.getAuthor().equals(search);
        }).collect(Collectors.toSet());

        return result;
    }
}
