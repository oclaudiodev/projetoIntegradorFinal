package projetointegradorfinal;

import java.util.Scanner;

public class ProjetoIntegradorFinal {

    public static void main(String[] args) {
        //AQUI PUXA TODAS AS FUNÇÕES!!!
        Scanner sc = new Scanner(System.in);
        int opcaoPrincipal = 0;
        int opcaoCliente = 0;
        int opcaoContato = 0;
        String[][] clientes = new String[0][8];
        String[][] contatos = new String[0][5];
        do {
            opcaoPrincipal = menuPrincipal(sc);
            switch (opcaoPrincipal) {
                case 0:
                    System.out.println("Encerrando Sistema!");
                    break;
                case 1: //1 - Gerenciar clientes
                    do {
                        opcaoCliente = menuCliente(sc);
                        if (opcaoCliente < 0 || opcaoCliente > 6) {
                            System.out.println("Opção Inválida");
                        } else if (opcaoCliente == 0) {
                            System.out.println("Saindo da aba Clientes");
                            System.out.println("");
                        } else if (opcaoCliente == 1) {
                            //1 - Incluir cliente
                        } else if (opcaoCliente == 2) {
                            //2 - Listar clientes (todos os clientes)

                        } else if (opcaoCliente == 3) {
                            //3 - Consultar cliente por código

                        } else if (opcaoCliente == 4) {
                            //4 - Alterar cliente

                        } else if (opcaoCliente == 5) {
                            //5 - Apagar cliente

                        } else if (opcaoCliente == 6) {
                            //6 - Ordenar por nome
                        }
                    } while (opcaoCliente != 0);
                    break;
                case 2: //2 - Gerenciar contatos
                    do {
                        opcaoContato = menuContato(sc);
                        if (opcaoContato < 0 || opcaoContato > 5) {
                            System.out.println("Opção Inválida");
                        } else if (opcaoContato == 0) {
                            System.out.println("Saindo da aba Contatos");
                            System.out.println("");
                        } else if (opcaoContato == 1) {
                            //1 - Incluir contato
                        } else if (opcaoContato == 2) {
                            //2 - Listar contatos (Todos os clientes)

                        } else if (opcaoContato == 3) {
                            //3 -  Listar contatos de um cliente

                        } else if (opcaoContato == 4) {
                            //4 - Alterar contato

                        } else if (opcaoContato == 5) {
                            //5 - Apagar contato
                        }
                    } while (opcaoContato != 0);
                    break;
                case 3: //3 - Relatórios
                    //  Listar cliente etotal de cliente por contato

                    //  Sumarização de dados
                    //o Total de cliente
                    //o Total de contatos
                    //o Contatos por cliente (média)
                    //o Clientes sem contato
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcaoPrincipal != 0);

    }

    //FUNÇÕES
    public static int pedirNumero(Scanner input) {
        int numero = input.nextInt();
        input.nextLine(); // já limpa o Enter aqui
        return numero;
    }

    public static String pedirTexto(Scanner input) {
        String texto = input.nextLine();
        return texto;
    }

    public static int menuPrincipal(Scanner input) {
        System.out.println("1 - Gerenciar clientes");
        System.out.println("2 - Gerenciar contatos");
        System.out.println("3 - Relatórios");
        System.out.println("0 – Sair");
        int opcao = pedirNumero(input);
        return opcao;
    }

    public static int menuCliente(Scanner input) {
        System.out.println("1 - Incluir cliente");
        System.out.println("2 - Listar clientes (todos os clientes)");
        System.out.println("3 - Consultar cliente por código");
        System.out.println("4 - Alterar cliente");
        System.out.println("5 - Apagar cliente");
        System.out.println("6 - Ordenar por nome");
        System.out.println("0 - Voltar");
        int opcao = pedirNumero(input);
        return opcao;
    }

    public static int menuContato(Scanner input) {
        System.out.println("1 - Incluir contato");
        System.out.println("2 - Listar contatos (Todos os clientes)");
        System.out.println("3 - Listar contatos de um cliente");
        System.out.println("4 - Alterar contato");
        System.out.println("5 - Apagar contato");
        System.out.println("0 - Voltar");
        int opcao = pedirNumero(input);
        return opcao;
    }

    //Clientes 
    //aumentarMatrizClientes

////[...]
   
    // incluirCliente
    ////[...]
    
    //listarClientesTabela
    ////[...]
    
    // buscarClientePorCodigo
    ////[...]
    
    // alterarCliente
    ////[...]
    
    // apagarCliente
    ////[...]
    
    // ordenarClientesPorNome
    ////[...]
    
    
    
    //CONTATOS
    
    
    //aumentarMatrizContatos
    ////[...]
    
    //incluirContato
    ////[...]
    
    //listarContatosTabela
    ////[...]
    
    //listarContatosPorCliente
    ////[...]
    
    //alterarContato
    ////[...]
    
    //apagarContato
    ////[...]
    
    
    //AUXILIARES
    
    
    //compararNomeCharPorChar
    ////[...]
    
    //copiarLinha
    ////[...]
    
    //limparLinha
    ////[...]
    
    //trocarLinhas
    ////[...]
    
}
