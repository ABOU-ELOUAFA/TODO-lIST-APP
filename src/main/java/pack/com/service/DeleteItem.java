package pack.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import pack.com.dao.TodoItemRepository;

@Component
public class DeleteItem implements DataFetcher<String> {
	@Autowired
	private TodoItemRepository todoItemRepository;

	@Override
	public String get(DataFetchingEnvironment environment) throws Exception {
		todoItemRepository.deleteById(environment.getArgument("id"));
		return "Deleted";
	}
}
