package pack.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import pack.com.dao.TodoItemRepository;
import pack.com.entities.TodoItem;

@Component
public class UpdateItem implements DataFetcher<TodoItem> {
	@Autowired
	TodoItemRepository todoItemRepository;

	@Override
	public TodoItem get(DataFetchingEnvironment environment) throws Exception {

		TodoItem todoItem = todoItemRepository.getById(environment.getArgument("id"));
		todoItem.setCategory(environment.getArgument("category"));
		todoItem.setName(environment.getArgument("name"));
		todoItem.setComplete(environment.getArgument("complete"));
		todoItemRepository.save(todoItem);

		return todoItem;
	}

}
