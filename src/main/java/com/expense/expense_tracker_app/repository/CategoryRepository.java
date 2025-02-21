package com.expense.expense_tracker_app.repository;

import com.expense.expense_tracker_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Spring data jpa provides implementation for this interface
    // CRUD methods to perform database operations on Category entity
    // Spring data JPA provides transaction for all the CRUD methods
}
