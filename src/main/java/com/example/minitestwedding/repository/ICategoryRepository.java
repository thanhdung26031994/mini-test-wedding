package com.example.minitestwedding.repository;

import com.example.minitestwedding.model.Category;
import com.example.minitestwedding.model.CountTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Query(nativeQuery = true, value = "select c.name as categoryName, sum(t.amount) as totalAmount from task right join category c on c.id = t.category_id group by c.name;")
    Iterable<CountTask> countTask();

}
