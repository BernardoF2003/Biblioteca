package app;

import impl.Book;
import impl.LibStatus;
import impl.Library;

import java.util.Scanner;

public class LibraryApp{
    public static void init(){
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\nSistema de Gestão de Biblioteca");
            System.out.println("Opções:");
            System.out.println("1 - Adicionar um livro novo ao acervo");
            System.out.println("2 - Listar todos os livros do acervo");
            System.out.println("3 - Pesquisar um livro no acervo pelo título");
            System.out.println("4 - Remover um livro do acervo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao){
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String title = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String author = scanner.nextLine();
                    System.out.print("Digite o ano de lançamento do livro: ");
                    int year = scanner.nextInt();
                    System.out.print("Digite o número de páginas do livro: ");
                    int npages = scanner.nextInt();
                    scanner.nextLine();
                    Book newBook = new Book(title, author, year, npages);
                    LibStatus status = library.addBook(newBook);
                    switch(status){
                        case SUCCESS:
                            System.out.println("Livro adicionado com sucesso!\n");
                            break;
                        case EMPTYAUTHOR:
                            System.out.println("Erro: Autor do livro está vazio!\n");
                            break;
                        case EMPTYTITLE:
                            System.out.println("Erro: Título do livro está vazio!\n");
                            break;
                        case DUPLICATED:
                            System.out.println("Erro: Livro já existe no acervo!\n");
                            break;
                    }
                    break;
                case 2:
                    System.out.println(library);
                    break;
                case 3:
                    System.out.print("Digite o título do livro que deseja pesquisar: ");
                    String searchTitle = scanner.nextLine();
                    Integer[] searchResult = library.searchBook(searchTitle);
                    if(searchResult[0] != -1){
                        Book foundBook = library.getBookByIndex(searchResult[1]);
                        System.out.println("Livro encontrado: " + foundBook);
                    }
                    else
                        System.out.println("Livro não encontrado.\n");
                    break;
                case 4:
                    System.out.print("Digite o título do livro que deseja remover: ");
                    String removeTitle = scanner.nextLine();
                    Book removeBook = new Book();
                    removeBook.setTitle(removeTitle);
                    LibStatus removeStatus = library.removeBook(removeBook);
                    if(removeStatus == LibStatus.REMOVED)
                        System.out.println("Livro removido com sucesso!\n");
                    else
                        System.out.println("Erro: Livro não encontrado no acervo.\n");
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        }
    }
}
