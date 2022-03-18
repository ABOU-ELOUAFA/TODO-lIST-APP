package pack.com.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;

@Service
public class GraphqlService {
	@Value("classpath:/graphql/TodoItem.graphql")
	private Resource resource;

	@Autowired
	private GetAllItems getAllItems;

	@Autowired
	private Additem additem;

	@Autowired
	private DeleteItem deleteItem;

	@Autowired
	private UpdateItem updateItem;

	private GraphQL graphQL;
	private GraphQL graphQL1;

	@PostConstruct
	private void getSchema() throws IOException {
		graphQL = GraphQL
				.newGraphQL(new SchemaGenerator().makeExecutableSchema(new SchemaParser().parse(resource.getFile()),
						RuntimeWiring.newRuntimeWiring()
								.type("Query", typeWiring -> typeWiring.dataFetcher("getAllItems", getAllItems))
								.type("Mutation", typeWiring -> typeWiring.dataFetcher("addItem", additem)
										.dataFetcher("deleteItem", deleteItem).dataFetcher("updateItem", updateItem))
								.build()))
				.build();

	}

	public GraphQL getGraphQL() {
		return graphQL;
	}

}
