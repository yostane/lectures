package org.eclipse.jakarta.dao;

import java.util.List;

import org.eclipse.jakarta.model.Book;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class BookDao {
    @PersistenceContext(unitName = "jpa-unit")
    private EntityManager em;

    public void add(Book book) {
        em.persist(book);
    }

    public List<Book> getAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }
}
