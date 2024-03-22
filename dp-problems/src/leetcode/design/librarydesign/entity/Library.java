package leetcode.design.librarydesign.entity;

import java.util.List;

public class Library {
    private List<Books> books;
    private Librarian librarian;
    private List<Users> users;

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
    public List<Books> getBooks() {
        return books;
    }


}
