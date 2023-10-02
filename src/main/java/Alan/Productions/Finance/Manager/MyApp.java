package Alan.Productions.Finance.Manager;

import Alan.Productions.Finance.Manager.Repository.UserRepository;
import Alan.Productions.Finance.Manager.Service.UserCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class MyApp implements CommandLineRunner {
    Scanner scanner = new Scanner(System.in);
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserCRUD crud;
    @Override
    public void run(String... args) throws Exception {
        Boolean isTrue = true;

        while (isTrue = true){
            System.out.println("1 - cadastrar novo usuario");
            System.out.println("2 - listar todos os usuários");
            System.out.println("3 - buscar todos os usuários pelo nome");
            System.out.println("4 - alterar usuário pelo ID");
            System.out.println("5 - deletar usuário pelo ID");
            System.out.println("0 - sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    crud.createUser();
                    break;
                case 2:
                    crud.returnAllUsers();
                    break;
                case 3:
                    crud.returnUsersByName();
                    break;
                case 4:
                    crud.alterUserById();
                    break;
                case 5:
                    crud.deleteUserById();
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }
    }
}
