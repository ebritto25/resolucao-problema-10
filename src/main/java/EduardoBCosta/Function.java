package EduardoBCosta;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;

import lombok.Data;

import com.microsoft.azure.functions.*;

public class Function {
    /**
     * This function listens at endpoint "/api/HttpTrigger-Java". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpTrigger-Java&code={your function key}
     * 2. curl "{your host}/api/HttpTrigger-Java?name=HTTP%20Query&code={your function key}"
     * Function Key is not needed when running locally, to invoke HttpTrigger deployed to Azure, see here(https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-http-webhook#authorization-keys) on how to get function key for your app.
     */

    ArrayList<Funcionario> funcionarios = new ArrayList<>();
    @FunctionName("createfuncionario")
    public Funcionario save(@HttpTrigger(name = "createfuncionario", 
                                        methods = {HttpMethod.POST},
                                        route = "funcionario"
                                    ) Funcionario funcionario) {
        
        funcionario.setId(new Long(funcionarios.size()));
        funcionarios.add(funcionario);
        return funcionario;
    }

    @FunctionName("getfuncionario")
    public ArrayList<Funcionario> read(@HttpTrigger(name = "getfuncionario", 
                                        methods = {HttpMethod.GET},
                                        route = "funcionario"
                                    ) String x) {
        
        return funcionarios;
    }

    @FunctionName("updatefuncionario")
    public Funcionario update(@HttpTrigger(name = "updatefuncionario", 
                                        methods = {HttpMethod.PUT},
                                        route = "funcionario"
                                    ) Funcionario funcionario) {
        
        funcionarios.add(funcionario);
        return funcionario;
    }

    @FunctionName("deletefuncionario")
    public int delete(@HttpTrigger(name = "deletefuncionario", 
                                        methods = {HttpMethod.DELETE},
                                        route = "funcionario"
                                    ) Long id) {
        
        funcionarios.remove(id);
        return 200;
    }
}

@Data
class Funcionario{
    private Long id;
    private String nome;
    private int idade;
    private double salario;
}