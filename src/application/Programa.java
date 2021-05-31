package application;

import java.util.Date;
import java.util.Scanner;
import entities.Aluno;
import jdbc.AlunoJDBC;

public class Programa {

	public static void main(String[] args) {
		
        try {
        	
            int opcao = 0;
            Scanner console = new Scanner(System.in);
            
            do {
                System.out.print("######## Menu ########"
                                 + "\n1- Cadastrar"
                                 + "\n2- Listar"
                                 + "\n3- Alterar"
                                 + "\n4- Excluir"
                                 + "\n5- Sair");
                System.out.print("\n\tOpção: ");
                opcao = Integer.parseInt(console.nextLine());
                System.out.println("\n\n\n\n");
                
                if (opcao == 1){
                    
                    Aluno a = new Aluno();
                    AlunoJDBC acao = new AlunoJDBC();
                    
                    System.out.print("\n*** Cadastrar Aluno ***\n\r");
                    
                    System.out.print("Nome: ");
                    a.setNome(console.nextLine());
                    System.out.print("Sexo: ");
                    a.setSexo(console.nextLine());
                    System.out.print("Data de nascimento: ");
                    a.setDt_nasc( new Date(console.nextLine()) );
                    System.out.print("matricula: ");
                    int id = console.nextInt();
                    a.setId(id);
                    acao.salvar(a);
                    console.nextLine();
                    System.out.println("\n\n\n\n");
                }if (opcao == 2) {
                	System.out.print("\n*** Lista de Alunos ***\n\r");
                	AlunoJDBC acao = new AlunoJDBC();
                	acao.listar();
                	console.nextLine();
                	System.out.println("\n\n\n\n");
                }
                if (opcao == 3){
                    
                	Aluno a = new Aluno();
                    AlunoJDBC acao = new AlunoJDBC();
                  
                    System.out.print("\n*** Alterar Aluno ***\n\r");
                    
                    System.out.print("Novo Nome: ");
                    a.setNome(console.nextLine());
                    System.out.print("Altera Sexo: ");
                    a.setSexo(console.nextLine());
                    System.out.print("Altera Data de nascimento: ");
                    a.setDt_nasc( new Date(console.nextLine()) );
                    System.out.print("Matricula a ser alterada: ");
                    int id = console.nextInt();
                    a.setId(id);
                    acao.alterar(a);
                    console.nextLine();
                    System.out.println("\n\n\n\n");
                }if (opcao == 4) {
                	AlunoJDBC acao = new AlunoJDBC();
                	System.out.print("\n*** Excluir Aluno ***\n\r");
                	System.out.print("Matricula a ser excluida: ");
                	int id = console.nextInt();
                    
                    acao.apagar(id);
                    console.nextLine();
                    System.out.println("\n\n\n\n");
                }
               
            } while(opcao != 5);
        } catch (Exception e){
            System.out.println("Erro: " + e);
        }
	}
}
