package leetcode.design.librarydesign.services;

import leetcode.design.librarydesign.entity.Books;

import java.util.Set;

@FunctionalInterface
public interface BookSearchEngine {
    public Set<Books> searchBook(String search);
}
