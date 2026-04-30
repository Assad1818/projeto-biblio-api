package com.guilhermeAssad.projeto_biblio_api.domain.service;

import com.guilhermeAssad.projeto_biblio_api.domain.model.Book;
import com.guilhermeAssad.projeto_biblio_api.domain.model.Rent;
import com.guilhermeAssad.projeto_biblio_api.domain.model.User;
import com.guilhermeAssad.projeto_biblio_api.domain.repository.BookRepository;
import com.guilhermeAssad.projeto_biblio_api.domain.repository.RentRepository;
import com.guilhermeAssad.projeto_biblio_api.domain.repository.UserRepository;
import com.guilhermeAssad.projeto_biblio_api.dto.request.RentRequest;
import com.guilhermeAssad.projeto_biblio_api.dto.response.RentResponse;
import com.guilhermeAssad.projeto_biblio_api.exception.book.BookAlreadyReturnException;
import com.guilhermeAssad.projeto_biblio_api.exception.book.BookNotFoundException;
import com.guilhermeAssad.projeto_biblio_api.exception.book.BookUnavailableException;
import com.guilhermeAssad.projeto_biblio_api.exception.rent.RentNotFoundException;
import com.guilhermeAssad.projeto_biblio_api.exception.user.UserNotFoundException;
import com.guilhermeAssad.projeto_biblio_api.mapper.RentMapper;
import com.guilhermeAssad.projeto_biblio_api.utils.EAvailable;
import com.guilhermeAssad.projeto_biblio_api.utils.ERentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RentService {

    private final RentRepository rentRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final RentMapper rentMapper;


    private Rent findRentOrThrow(Long id) {
        return rentRepository.findById(id)
                .orElseThrow(() -> new RentNotFoundException(id));
    }

    private User findUserOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    private Book findBookOrThrow(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private void validateBookAvailability(Book book) {
        if (book.getAvailable() == EAvailable.NO) {
            throw new BookUnavailableException(book.getName());
        }
    }

    public RentResponse create(RentRequest request) {

        User user = findUserOrThrow(request.userId());
        Book book = findBookOrThrow(request.bookId());

        validateBookAvailability(book);

        Rent rent = new Rent();
        rent.setUser(user);
        rent.setBook(book);
        rent.setStatus(ERentStatus.RENTED);

        book.setAvailable(EAvailable.NO);
        bookRepository.save(book);

        return rentMapper.toResponse(rentRepository.save(rent));
    }

    public RentResponse returnBook(Long rentId) {
        Rent rent = findRentOrThrow(rentId);

        if (rent.getStatus() == ERentStatus.RETURNED) {
            throw new BookAlreadyReturnException(rent.getBook().getName());
        }

        rent.setStatus(ERentStatus.RETURNED);
        rent.setDateReturn(LocalDateTime.now());

        Book book = rent.getBook();
        book.setAvailable(EAvailable.YES);
        bookRepository.save(book);

        return rentMapper.toResponse(rentRepository.save(rent));
    }


    public void delete(Long id) {
        Rent rent = findRentOrThrow(id);
        rentRepository.delete(rent);
    }

    public RentResponse getById(Long id) {
        Rent rent = findRentOrThrow(id);
        return rentMapper.toResponse(rent);
    }

    public List<RentResponse> findAll() {
        return rentMapper.toRentResponseList(rentRepository.findAll());
    }

    public List<RentResponse> findActiveRents() {
        return rentMapper.toRentResponseList(
                rentRepository.findByStatus(ERentStatus.RENTED)
        );
    }

    public List<RentResponse> findReturnedRents() {
        return rentMapper.toRentResponseList(
                rentRepository.findByStatus(ERentStatus.RETURNED)
        );
    }

    public List<RentResponse> findByUser(Long userId) {
        findUserOrThrow(userId);
        return rentMapper.toRentResponseList(
                rentRepository.findByUserId(userId)
        );
    }

    public List<RentResponse> findByBook(Long bookId) {
        findBookOrThrow(bookId);
        return rentMapper.toRentResponseList(
                rentRepository.findByBookId(bookId)
        );
    }
}