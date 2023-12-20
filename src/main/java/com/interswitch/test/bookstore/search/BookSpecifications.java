package com.interswitch.test.bookstore.search;

import com.interswitch.test.bookstore.domain.Book;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class BookSpecifications {

    public static Specification<Book> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
                title == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Book> hasGenre(String genre) {
        return (root, query, criteriaBuilder) ->
                genre == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(criteriaBuilder.lower(root.get("genre")), genre.toLowerCase());
    }

    public static Specification<Book> hasIsbn(String isbn) {
        return (root, query, criteriaBuilder) ->
                isbn == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get("isbn"), isbn);
    }

    public static Specification<Book> hasAuthor(String author) {
        return (root, query, criteriaBuilder) ->
                author == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("author")), "%" + author.toLowerCase() + "%");
    }

    public static Specification<Book> hasYearOfPublication(String year) {
        return (root, query, criteriaBuilder) ->
                year == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get("yearOfPublication"), year);
    }

    public static Specification<Book> createSpecification(Map<String, String> criteria) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            // Iterate over the criteria map and dynamically build the query
            for (Map.Entry<String, String> entry : criteria.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (key.equals("title")) {
                    predicate = criteriaBuilder.and(predicate,
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + value.toLowerCase() + "%"));
                } else if (key.equals("genre")) {
                    predicate = criteriaBuilder.and(predicate,
                            criteriaBuilder.equal(criteriaBuilder.lower(root.get("genre")), value.toLowerCase()));
                }else if (key.equals("author")) {
                    predicate = criteriaBuilder.and(predicate,
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("author")), "%" + value.toLowerCase() + "%"));
                } else if (key.equals("yearOfPublication")) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("yearOfPublication"), value));
                }
            }

            return predicate;
        };
    }
}

