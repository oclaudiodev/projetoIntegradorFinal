package projetointegradorfinal;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProjetoIntegradorFinal {

    public static void main(String[] args) {
        //AQUI PUXA TODAS AS FUNÇÕES!!!
        Scanner sc = new Scanner(System.in);
        int opcaoPrincipal = 0;
        int opcaoCliente = 0;
        int opcaoContato = 0;
        int opcaoRelatorio = 0;
        int clientesTamanhoMatriz = 0;
        int contatosTamanhoMatriz = 0;
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
                            clientes = aumentarMatrizClientes(clientes);
                            incluirCliente(clientes, sc, clientesTamanhoMatriz);
                            clientesTamanhoMatriz++;
                        } else if (opcaoCliente == 2) {
                            //2 - Listar clientes (todos os clientes)
                            listarClientes(clientes, clientesTamanhoMatriz);

                        } else if (opcaoCliente == 3) {
                            //3 - Consultar cliente por código
                            int codigo = buscarClientePorCodigo(clientes, sc);
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
                    do {
                        opcaoRelatorio = menuRelatorio(sc);
                        switch (opcaoRelatorio) {
                            case 0:
                                System.out.println("Saindo da aba de Relatorios");
                                break;
                            case 1:
                                //  Listar cliente etotal de cliente por contato
                                break;
                            case 2:
                                //  Sumarização de dados
                                //o Total de cliente
                                //o Total de contatos
                                //o Contatos por cliente (média)
                                //o Clientes sem contato
                                break;
                            default:
                                System.out.println("Opção inválida... Por favor digite uma opcao valida.");
                        }
                    } while (opcaoRelatorio != 0);
                    break;
                case 4:
                    
                    clientes = carregarClientesCSV();
                    contatos = carregarContatosCSV();

                    clientesTamanhoMatriz = clientes.length;

                    System.out.println("Dados carregados com sucesso!");
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
        System.out.println("4 - Carregar dados de teste (CSV)");
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

    public static int menuRelatorio(Scanner input) {
        System.out.println("1 - Listar Clientes");
        System.out.println("2 - Sumarização de Dados");
        System.out.println("0 - Voltar");
        int opcao = input.nextInt();
        return opcao;
    }

    //Clientes
    //aumentarMatrizClientes
    public static String[][] aumentarMatrizClientes(String[][] clientesAntiga) {
        int novaLinha = clientesAntiga.length + 1;
        String[][] novaMatrizClientes = new String[novaLinha][8];
        for (int i = 0; i < clientesAntiga.length; i++) {
            for (int j = 0; j < clientesAntiga[i].length; j++) {
                novaMatrizClientes[i][j] = clientesAntiga[i][j];
            }
        }
        return novaMatrizClientes;
    }

    // incluirCliente
    public static void incluirCliente(String[][] incluirCliente, Scanner input, int limitadorMatriz) {
        for (int i = limitadorMatriz; i < incluirCliente.length; i++) {
            for (int j = 0; j < incluirCliente[i].length; j++) {
                switch (j) {
                    case 0:
                        incluirCliente[i][j] = String.valueOf(i + 1);
                        break;
                    case 1:
                        System.out.println("Nome: ");
                        incluirCliente[i][j] = input.nextLine();
                        break;
                    case 2:
                        System.out.println("Cpf: ");
                        incluirCliente[i][j] = input.nextLine();
                        break;
                    case 3:
                        System.out.println("Data de nascimento: ");
                        incluirCliente[i][j] = input.nextLine();
                        break;
                    case 4:
                        System.out.println("Sexo: ");
                        incluirCliente[i][j] = input.nextLine();
                        break;
                    case 5:
                        System.out.println("Cidade: ");
                        incluirCliente[i][j] = input.nextLine();
                        break;
                    case 6:
                        System.out.println("Estado: ");
                        incluirCliente[i][j] = input.nextLine();
                        break;
                    case 7:
                        System.out.println("Status: ");
                        incluirCliente[i][j] = input.nextLine();
                        break;
                }
            }
        }
    }

    //listarClientesTabela
    public static void listarClientes(String[][] listarCliente, int tamanhoMatriz) {
        System.out.printf("%-25.25s|%-25.25s|%-25.25s|%-25.25s|%-25.25s|%-25.25s|%-25.25s|%-25.25s\n", "Codigo", "Nome", "CPF/CNPJ", "Data de nascimento", "Sexo", "Cidade", "Estado", "Status");
        for (int i = 0; i < tamanhoMatriz; i++) {
            for (int j = 0; j < listarCliente[i].length; j++) {
                System.out.printf("%-25.25s", listarCliente[i][j]);
            }
            System.out.println();
            System.out.println();
        }
    }

    ////[...]

    // buscarClientePorCodigo
    public static int buscarClientePorCodigo(String[][] cliente, Scanner input) {
        System.out.println("Código: ");
        String n = input.next();

        if (n.equals("0")) {
            return -1;
        }
        if (n != null && !n.isEmpty()) {//verifica se n esta vazio ou nulo
            System.out.printf("%-25.25s|%-25.25s|%-25.25s|%-25.25s|%-25.25s|%-25.25s|%-25.25s|%-25.25s\n", "Codigo", "Nome", "CPF/CNPJ", "Data de nascimento", "Sexo", "Cidade", "Estado", "Status");
            for (int i = 0; i < cliente.length; i++) {

                if (cliente[i][0] != null && n.equals(cliente[i][0])) {

                    for (int j = 0; j < cliente[i].length; j++) {
                        System.out.printf("%-25.25s", cliente[i][j]);
                    }
                    System.out.println("");
                    System.out.println("");
                    return i;
                }
            }
        }

        System.out.println("Cliente não encontrado.");
        return -1;
    }
    
    

    // alterarCliente

////[...]

    // apagarCliente
    ////[...]

    // ordenarClientesPorNome
    ////[...]



    //CONTATOS


    //aumentarMatrizContatos
    private static String[][] aumentarMatrizContatos(String[][] matrizContatos) {

        return matrizContatos;
    }
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
    ///
    ///
    // ========== FUNÇÕES DE CARREGAMENTO DE DADOS ==========
    
    /*
      Carrega clientes do arquivo clientes.csv
      Formato: codigo,nome,cpf_cnpj,data_nascimento,sexo,cidade,estado,status
     */
    private static String[][] carregarClientesCSV() {
        String arquivo = "clientes.csv";
        String[][] matrizClientes = new String[0][8];
        int contador = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true;
            
            while ((linha = br.readLine()) != null) {
                // Pula o cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                
                // Divide a linha por vírgula
                String[] dados = linha.split(",");
                
                if (dados.length >= 8) {
                    // Aumenta a matriz em 1 linha
                    matrizClientes = aumentarMatrizClientes(matrizClientes);
                    int indice = matrizClientes.length - 1;
                    
                    // Preenche a nova linha com os dados do CSV
                    matrizClientes[indice][0] = dados[0].trim(); // codigo
                    matrizClientes[indice][1] = dados[1].trim(); // nome
                    matrizClientes[indice][2] = dados[2].trim(); // cpf_cnpj
                    matrizClientes[indice][3] = dados[3].trim(); // data_nascimento
                    matrizClientes[indice][4] = dados[4].trim(); // sexo
                    matrizClientes[indice][5] = dados[5].trim(); // cidade
                    matrizClientes[indice][6] = dados[6].trim(); // estado
                    matrizClientes[indice][7] = dados[7].trim().toUpperCase(); // status
                    
                    contador++;
                }
            }
            
            System.out.println("✓ " + contador + " clientes foram carregados do arquivo.");
            
        } catch (IOException e) {
            System.out.println("\n✗ Erro ao ler arquivo " + arquivo + ": " + e.getMessage());
            System.out.println("Certifique-se de que o arquivo existe no diretório do projeto.");
        }
        
        return matrizClientes;
    }
    
    /*
      Carrega contatos do arquivo contatos.csv
      Formato: codigo_contato,codigo_cliente,tipo,valor,status
     */
    private static String[][] carregarContatosCSV() {
        String arquivo = "contatos.csv";
        String[][] matrizContatos = new String[0][5];
        int contador = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true;
            
            while ((linha = br.readLine()) != null) {
                // Pula o cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                
                // Divide a linha por vírgula
                String[] dados = linha.split(",");
                
                if (dados.length >= 5) {
                    // Aumenta a matriz em 1 linha
                    matrizContatos = aumentarMatrizContatos(matrizContatos);
                    int indice = matrizContatos.length - 1;
                    
                    // Preenche a nova linha com os dados do CSV
                    matrizContatos[indice][0] = dados[0].trim(); // codigo_contato
                    matrizContatos[indice][1] = dados[1].trim(); // codigo_cliente
                    matrizContatos[indice][2] = dados[2].trim(); // tipo
                    matrizContatos[indice][3] = dados[3].trim(); // valor
                    matrizContatos[indice][4] = dados[4].trim().toUpperCase(); // status
                    
                    contador++;
                }
            }
            
            System.out.println("✓ " + contador + " contatos foram carregados do arquivo.");
            
        } catch (IOException e) {
            System.out.println("\n✗ Erro ao ler arquivo " + arquivo + ": " + e.getMessage());
            System.out.println("Certifique-se de que o arquivo existe no diretório do projeto.");
        }
        
        return matrizContatos;
    }
     
     

}
