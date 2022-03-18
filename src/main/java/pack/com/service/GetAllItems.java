package pack.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import pack.com.dao.TodoItemRepository;
import pack.com.entities.TodoItem;

@Component
public class GetAllItems implements DataFetcher<List<TodoItem>> {
	@Autowired
	private TodoItemRepository todoItemRepository;

	@Override
	public List<TodoItem> get(DataFetchingEnvironment environment) throws Exception {

		return todoItemRepository.findAll();
	}
}
