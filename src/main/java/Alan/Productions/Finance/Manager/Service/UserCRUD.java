package Alan.Productions.Finance.Manager.Service;

import Alan.Productions.Finance.Manager.Model.User;
import Alan.Productions.Finance.Manager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class UserCRUD {
    Scanner scanner = new Scanner(System.in);
    @Autowired
    UserRepository repository;
    public void createUser(){
        System.out.print("digite o nome do usuário: ");
        String nome = scanner.next();
        System.out.print("digite o cargo do usuário: ");
        String cargo = scanner.next();
        User u = new User();
        u.setName(nome);
        u.setCargo(cargo);
        repository.save(u);
        System.out.println("---Novo usuário cadastrado---");
        System.out.println("");
    }
    public void alterUserById(){
        System.out.print("informe o Id do usuário: ");
        int id = scanner.nextInt();
        Optional <User> optional = repository.findById(id);
        User altUser = optional.get();
        System.out.print("Digite o novo nome deste usuário: ");
        String nome = scanner.next();
        System.out.print("Digite o novo cargo deste usuário: ");
        String cargo = scanner.next();
        altUser.setName(nome);
        altUser.setCargo(cargo);
        repository.save(altUser);
        System.out.println("");
    }
    public void deleteUserById(){
        System.out.print("digite o Id do usuário a ser deletado: ");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("");
    }
    public void returnAllUsers(){
       List<User> lista = repository.findAll();
       for(User u: lista){
           System.out.println(u);
       }
        System.out.println("");
    }
    public void returnUsersByName(){
        System.out.print("digite o nome do usuário para busca: ");
        String nome = scanner.next();
        List<User> lista = repository.findAll();
        for (User u : lista){
            if (u.getName().equals(nome)){
                System.out.println(u);
            }
        }
        System.out.println("");
    }
}
