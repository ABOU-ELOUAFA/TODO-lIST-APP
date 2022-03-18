package pack.com.web;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;
import pack.com.service.GraphqlService;

@RestController
@RequestMapping("/todo")
public class TodoItemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TodoItemController.class);

	@Autowired
	private GraphqlService graphqlService;

	@PostMapping
	public ResponseEntity<ExecutionResult> operations(@RequestBody String string) {
		try {

			return new ResponseEntity<>(graphqlService.getGraphQL().execute(string), HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.info("Error Occured in method operations", e.getMessage());
			throw new RuntimeErrorException(new Error(e.getMessage()));
		}

	}

}
