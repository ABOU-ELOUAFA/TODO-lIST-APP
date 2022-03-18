package pack.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.com.entities.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {

}
