package org.example.library.repository;

import org.example.library.models.Book;
import org.example.library.models.TakenBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TakenBooksRepository extends JpaRepository<TakenBooks, Long> {
    List<TakenBooks> findAllByUserId(Long userId);
    List<TakenBooks> findAllByBookId(Long bookId);
//    @Query("select * where t")
//    TakenBooks lastUser(Long bookId);
}
