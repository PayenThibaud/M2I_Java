package org.example.correctionexercice1.service;

import org.example.correctionexercice1.Dto.AuthorDto;
import org.example.correctionexercice1.Dto.BookDtoReceive;
import org.example.correctionexercice1.Dto.BookDtoSend;
import org.example.correctionexercice1.Util.RestClient;
import org.example.correctionexercice1.annotation.Log;
import org.example.correctionexercice1.annotation.Performance;
import org.example.correctionexercice1.entity.Book;
import org.example.correctionexercice1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Log
    @Performance
    public BookDtoSend save (BookDtoReceive bookDtoReceive){
        RestClient<AuthorDto> authorRestClient = new RestClient<>("http://localhost:8081/api/author/"+bookDtoReceive.getAuthorId());
        AuthorDto authorDto = authorRestClient.getRequest(AuthorDto.class);
        if(authorDto != null){
            Book book = Book.builder()
                    .name(bookDtoReceive.getName())
                    .authorId(authorDto.getId())
                    .build();

            return  booktToBookDtoSend(bookRepository.save(book));
        }
        throw new RuntimeException("Author not found");
    }

    @Log
    @Performance
    public Book findById(long id){
        return bookRepository.findById(id).orElseThrow();
    }

    public BookDtoSend getById(long id){
        return booktToBookDtoSend(findById(id));
    }

    @Log
    @Performance
    public List<BookDtoSend> findAll(){

        return booksToBookDtoSends((List<Book>) bookRepository.findAll());
    }

    @Log
    @Performance
    public BookDtoSend update (long id,BookDtoReceive bookDtoReceive){
        RestClient<AuthorDto> authorRestClient = new RestClient<>("http://localhost:8081/api/author/"+bookDtoReceive.getAuthorId());
        AuthorDto authorDto = authorRestClient.getRequest(AuthorDto.class);
        if(authorDto != null){
            Book book = findById(id);
            book.setName(bookDtoReceive.getName());
            book.setAuthorId(authorDto.getId());

            return  booktToBookDtoSend(bookRepository.save(book));
        }
        throw new RuntimeException("author not found");
    }

    @Log
    @Performance
    public void delete (long id){
        bookRepository.delete(findById(id));
    }

    private BookDtoSend booktToBookDtoSend (Book book){
        RestClient<AuthorDto> authorRestClient = new RestClient<>("http://localhost:8081/api/author/"+book.getAuthorId());
        AuthorDto authorDto = authorRestClient.getRequest(AuthorDto.class);

        return BookDtoSend.builder()
                .id(book.getId())
                .name(book.getName())
                .author(authorDto)
                .build();
    }

    private List<BookDtoSend>  booksToBookDtoSends (List<Book> books){
        return books.stream().map(this::booktToBookDtoSend).toList();
    }
}
