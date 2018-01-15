package com.mycompany.graphql.Controller;

import com.mycompany.graphql.Service.AllPersonService;
import com.mycompany.graphql.Service.GetPersonByID;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author D.Nazer
 */
@RestController
public class GraphController {

    //load file GraphSchema file
    @Value("classpath:GraphSchema.graphqls")
    private Resource schemaResource;

    private GraphQL graphQL;

    @Autowired
    private AllPersonService getAllPersonSercive;

    @Autowired
    private GetPersonByID getPersonByID;

    //start to load file
    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = schemaResource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring runtimeWiring = BuildRuntimeWiring();

        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring BuildRuntimeWiring() {

        //custom data featcher
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typewirring -> typewirring
                .dataFetcher("getAllPerson", getAllPersonSercive)
                .dataFetcher("getById", getPersonByID)
                )
                .build();

    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult RESULT = graphQL.execute(query);
        return ResponseEntity.ok(RESULT.getData());
    }

}
