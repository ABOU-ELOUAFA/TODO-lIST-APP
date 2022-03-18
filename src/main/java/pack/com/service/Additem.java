package pack.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import pack.com.dao.TodoItemRepository;
import pack.com.entities.TodoItem;

@Component
public class Additem implements DataFetcher<TodoItem> {
	@Autowired
	private TodoItemRepository todoItemRepository;

	@Override
	public TodoItem get(DataFetchingEnvironment environment) throws Exception {
		TodoItem todoItem = new TodoItem(environment.getArgument("category"), environment.getArgument("name"),
				environment.getArgument("complete"));
		todoItemRepository.save(todoItem);

		return todoItem;
	}

}
