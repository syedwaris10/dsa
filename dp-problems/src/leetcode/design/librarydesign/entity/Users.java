package leetcode.design.librarydesign.entity;

import java.util.List;

public class Users {
    private String id;
    private String name;
    private List<Books> issuedBook;
    private List<Books> returnedBook;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Books> getIssuedBook() {
        return issuedBook;
    }

    public void setIssuedBook(List<Books> issuedBook) {
        this.issuedBook = issuedBook;
    }

    public List<Books> getReturnedBook() {
        return returnedBook;
    }

    public void setReturnedBook(List<Books> returnedBook) {
        this.returnedBook = returnedBook;
    }
}
