package com.siedge.app.Bookshop.Controller;

import com.siedge.app.Bookshop.Models.BooksBerezovskyi;
import com.siedge.app.Bookshop.Repo.BooksRepoBerezovskyi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksControllerBerezovskyi {

    // mark by annotation autowired for give bean template to BooksRepoBerezvoskyi
    @Autowired
    private BooksRepoBerezovskyi booksRepoBerezovskyi;
    //cRud - reading

    // testing message for http://localhost:8080
    @GetMapping
    public String getMessage () {
        return "Hello, Siedge";
    }

    // show all books from data base http://localhost:8080/books
    @GetMapping("/books")
    public List<BooksBerezovskyi> getBooks() {
        return booksRepoBerezovskyi.findAll();
    }

    // post new book to list http://localhost:8080/save
    @PostMapping ("/save")
    public String saveBooks(@RequestBody BooksBerezovskyi booksBerezovskyi) {
    booksRepoBerezovskyi.save(booksBerezovskyi);
    return "Dane zostałe zapisane";
    }

    // edit data in the existing book in database
    @PutMapping(value = "/edit/{id}")  //http://localhost:8080/edit/{book's id}

    /*get data via JPARepository of our book to map and edit. Annotation PathVariable is needed to find element with id book to edit*/
    public String editBooksBerezovskyi(@PathVariable  long id, @RequestBody BooksBerezovskyi booksBerezovskyi){
        BooksBerezovskyi editedBookBerezovskyi = booksRepoBerezovskyi.findById(id).get();
        editedBookBerezovskyi.setTitleBerezovskyi(booksBerezovskyi.getTitleBerezovskyi());
        editedBookBerezovskyi.setAuthorBerezovskyi(booksBerezovskyi.getAuthorBerezovskyi());
        editedBookBerezovskyi.setQuantityBerezovskyi(booksBerezovskyi.getQuantityBerezovskyi());
        editedBookBerezovskyi.setPriceBerezovskyi(booksBerezovskyi.getPriceBerezovskyi());
        return "Dane zostałe edytowane";
    }


    // delete any book in database
    @DeleteMapping("/delete/{id}")
    public String deleteBooks(@PathVariable long id){
        BooksBerezovskyi deleteBook = booksRepoBerezovskyi.findById(id).get();
        booksRepoBerezovskyi.delete(deleteBook);
        return "Book with id: " + id + " has been deleted";
    }
}
