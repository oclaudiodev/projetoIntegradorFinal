package projetointegradorfinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProjetoIntegradorFinal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcaoPrincipal = 0;
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
                case 1:
                    clientes = gerenciarClientes(clientes, clientesTamanhoMatriz, sc);
                    clientesTamanhoMatriz = clientes.length;
                    break;
                case 2:
                    contatos = gerenciarContatos(contatos, contatosTamanhoMatriz, clientes, clientesTamanhoMatriz, sc);
                    contatosTamanhoMatriz = contatos.length;
                    break;
                case 3:
                    gerenciarRelatorios(clientes, clientesTamanhoMatriz, contatos, contatosTamanhoMatriz, sc);
                    break;
                case 4:
                    clientes = carregarClientesCSV();
                    contatos = carregarContatosCSV();
                    clientesTamanhoMatriz = clientes.length;
                    contatosTamanhoMatriz = contatos.length;
                    System.out.println("Dados carregados com sucesso!");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcaoPrincipal != 0);
    }

    // Menu Gerenciar Clientes
    public static String[][] gerenciarClientes(String[][] clientes, int clientesTamanhoMatriz, Scanner sc) {
        int opcaoCliente = 0;
        do {
            opcaoCliente = menuCliente(sc);
            if (opcaoCliente < 0 || opcaoCliente > 6) {
                System.out.println("Opção Inválida");
            } else if (opcaoCliente == 0) {
                System.out.println("Saindo da aba Clientes");
                System.out.println("");
            } else if (opcaoCliente == 1) {
                clientes = aumentarMatrizClientes(clientes);
                incluirCliente(clientes, sc, clientesTamanhoMatriz);
                clientesTamanhoMatriz++;
            } else if (opcaoCliente == 2) {
                listarClientes(clientes);
            } else if (opcaoCliente == 3) {
                buscarClientePorCodigo(clientes, sc);
            } else if (opcaoCliente == 4) {
                alterarCliente(clientes, sc);
            } else if (opcaoCliente == 5) {
                clientes = apagarClientes(clientes, sc);
                clientesTamanhoMatriz = clientes.length;
            } else if (opcaoCliente == 6) {
                ordenarClientesPorNome(clientes);
            }
        } while (opcaoCliente != 0);
        return clientes;
    }

    // Menu Gerenciar Contatos
    public static String[][] gerenciarContatos(String[][] contatos, int contatosTamanhoMatriz, String[][] clientes, int clientesTamanhoMatriz, Scanner sc) {
        int opcaoContato = 0;
        do {
            opcaoContato = menuContato(sc);
            if (opcaoContato < 0 || opcaoContato > 5) {
                System.out.println("Opção Inválida");
            } else if (opcaoContato == 0) {
                System.out.println("Saindo da aba Contatos");
                System.out.println("");
            } else if (opcaoContato == 1) {
                // incluirContato
                contatos = aumentarMatrizContatos(contatos);
                incluirContato(contatos, sc, contatosTamanhoMatriz, clientes);
                contatosTamanhoMatriz++;
            } else if (opcaoContato == 2) {
                listarContatos(contatos);
            } else if (opcaoContato == 3) {
                listarContatosPorCliente(clientes, contatos, sc);
            } else if (opcaoContato == 4) {
                alterarContato(contatos, sc);
            } else if (opcaoContato == 5) {
                contatos = apagarContato(contatos, sc);
                contatosTamanhoMatriz = contatos.length;
            }
        } while (opcaoContato != 0);
        return contatos;
    }

    public static void gerenciarRelatorios(String[][] clientes, int clientesTamanhoMatriz, String[][] contatos, int contatosTamanhoMatriz, Scanner sc) {
        int opcaoRelatorio = 0;
        do {
            opcaoRelatorio = menuRelatorio(sc);
            switch (opcaoRelatorio) {
                case 0:
                    System.out.println("Saindo da aba de Relatorios");
                    break;
                case 1:
                    // Listar cliente e total de cliente por contato
                    relatorioPorCliente(clientes, contatos);
                    break;
                case 2:
                    // Sumarização de dados
                    sumarizaçãoDeDados(clientes, contatos, clientesTamanhoMatriz, contatosTamanhoMatriz);
                    break;
                default:
                    System.out.println("Opção inválida... Por favor digite uma opcao valida.");
            }
        } while (opcaoRelatorio != 0);
    }

    // ========== FUNÇÕES ==========
    public static int pedirNumero(Scanner inputNum) {
        int numero = inputNum.nextInt();
        inputNum.nextLine();
        return numero;
    }

    public static String pedirTexto(Scanner inputText) {
        String texto = inputText.nextLine();
        return texto;
    }

    public static int menuPrincipal(Scanner inputNum) {
        System.out.println("1 - Gerenciar clientes");
        System.out.println("2 - Gerenciar contatos");
        System.out.println("3 - Relatórios");
        System.out.println("4 - Carregar dados de teste (CSV)");
        System.out.println("0 – Sair");
        return pedirNumero(inputNum);
    }

    public static int menuCliente(Scanner inputNum) {
        System.out.println("1 - Incluir cliente");
        System.out.println("2 - Listar clientes (todos os clientes)");
        System.out.println("3 - Consultar cliente por código");
        System.out.println("4 - Alterar cliente");
        System.out.println("5 - Apagar cliente");
        System.out.println("6 - Ordenar por nome");
        System.out.println("0 - Voltar");
        return pedirNumero(inputNum);
    }

    public static int menuContato(Scanner inputNum) {
        System.out.println("1 - Incluir contato");
        System.out.println("2 - Listar contatos (Todos os clientes)");
        System.out.println("3 - Listar contatos de um cliente");
        System.out.println("4 - Alterar contato");
        System.out.println("5 - Apagar contato");
        System.out.println("0 - Voltar");
        return pedirNumero(inputNum);
    }

    public static int menuRelatorio(Scanner inputNum) {
        System.out.println("1 - Listar Clientes");
        System.out.println("2 - Sumarização de Dados");
        System.out.println("0 - Voltar");
        return pedirNumero(inputNum);
    }

    // ========== CLIENTES ==========
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

    public static void incluirCliente(String[][] incluirCliente, Scanner inputText, int limitadorMatriz) {
        for (int i = limitadorMatriz; i < incluirCliente.length; i++) {
            for (int j = 0; j < incluirCliente[i].length; j++) {
                switch (j) {
                    case 0:
                        incluirCliente[i][j] = String.valueOf(gerarNovoCodigoCliente(incluirCliente));
                        break;
                    case 1:
                        System.out.println("Nome: ");
                        incluirCliente[i][j] = pedirTexto(inputText);
                        break;
                    case 2:
                        System.out.println("Cpf: ");
                        incluirCliente[i][j] = pedirTexto(inputText);
                        break;
                    case 3:
                        System.out.println("Data de nascimento: ");
                        incluirCliente[i][j] = pedirTexto(inputText);
                        break;
                    case 4:
                        System.out.println("Sexo(M/F): ");
                        incluirCliente[i][j] = pedirTexto(inputText);
                        break;
                    case 5:
                        System.out.println("Cidade: ");
                        incluirCliente[i][j] = pedirTexto(inputText);
                        break;
                    case 6:
                        System.out.println("Estado: ");
                        incluirCliente[i][j] = pedirTexto(inputText);
                        break;
                    case 7:
                        System.out.println("Status: ");
                        incluirCliente[i][j] = pedirTexto(inputText);
                        break;
                }
            }
        }
    }

    // Função auxiliar: imprime cabeçalho e separador da tabela de clientes
    public static void imprimirCabecalhoClientes() {
        System.out.printf("%-7s | %-20s | %-15s | %-12s | %-5s | %-20s | %-7s | %-8s%n",
                "Codigo", "Nome", "CPF/CNPJ", "Nascimento", "Sexo", "Cidade", "Estado", "Status");
        System.out.println("--------+----------------------+-----------------+--------------+-------+----------------------+---------+---------");
    }

    // Função auxiliar: imprime uma linha da tabela de clientes
    public static void imprimirLinha(String[] linha) {
        System.out.printf("%-7s | %-20s | %-15s | %-12s | %-5s | %-20s | %-7s | %-8s%n",
                linha[0], linha[1], linha[2], linha[3],
                linha[4], linha[5], linha[6], linha[7]);
    }

    public static void listarClientes(String[][] listarCliente) {
        if (listarCliente.length == 0) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        imprimirCabecalhoClientes();
        for (int i = 0; i < listarCliente.length; i++) {
            imprimirLinha(listarCliente[i]);
        }
        System.out.println();
    }

    public static int buscarClientePorCodigo(String[][] cliente, Scanner input) {
        System.out.print("Código: ");
        String n = input.next();
        input.nextLine();

        if (n.equals("0")) {
            return -1;
        }
        if (n != null && !n.isEmpty()) {
            for (int i = 0; i < cliente.length; i++) {
                if (cliente[i][0] != null && n.equals(cliente[i][0])) {
                    imprimirCabecalhoClientes();
                    imprimirLinha(cliente[i]);
                    System.out.println();
                    return i;
                }
            }
        }
        System.out.println("Cliente não encontrado.");
        return -1;
    }

    // alterarCliente
    public static String[][] alterarCliente(String[][] cliente, Scanner input) {
        System.out.println("Digite o código do Cliente que você deseja alterar os dados: ");
        String n = input.next();
        String novaLinha[][] = new String[cliente.length][8];
        input.nextLine();
        if (n.equals("0")) {
            System.out.println("Código Zero ou abaixo de Zero é inválido");;
            System.out.println("");
        }
        if (n != null && !n.isEmpty()) {
            System.out.println("Alterando os dados da linha: " + n);
            for (int i = 0; i < cliente.length; i++) {
                for (int j = 0; j < cliente[i].length; j++) {
                    if (cliente[i][0] != null && n.equals(cliente[i][0])) {
                        switch (j) {
                            case 0:
                                break;
                            case 1:
                                System.out.println("Nome: ");
                                novaLinha[i][j] = input.nextLine();
                                cliente[i][j] = novaLinha[i][j];
                                break;
                            case 2:
                                System.out.println("Cpf: ");
                                novaLinha[i][j] = input.nextLine();
                                cliente[i][j] = novaLinha[i][j];
                                break;
                            case 3:
                                System.out.println("Data de nascimento: ");
                                novaLinha[i][j] = input.nextLine();
                                cliente[i][j] = novaLinha[i][j];
                                break;
                            case 4:
                                System.out.println("Sexo: ");
                                novaLinha[i][j] = input.nextLine();
                                cliente[i][j] = novaLinha[i][j];
                                break;
                            case 5:
                                System.out.println("Cidade: ");
                                novaLinha[i][j] = input.nextLine();
                                cliente[i][j] = novaLinha[i][j];
                                break;
                            case 6:
                                System.out.println("Estado: ");
                                novaLinha[i][j] = input.nextLine();
                                cliente[i][j] = novaLinha[i][j];
                                break;
                            case 7:
                                System.out.println("Status: ");
                                novaLinha[i][j] = input.nextLine();
                                cliente[i][j] = novaLinha[i][j];
                                break;
                        }
                    }
                }
            }
        }
        return cliente;
    }

    public static int gerarNovoCodigoCliente(String[][] clientes) {

        int maiorCodigo = 0;

        for (int i = 0; i < clientes.length; i++) {

            if (clientes[i][0] != null) {

                int codigoAtual = Integer.parseInt(clientes[i][0]);

                if (codigoAtual > maiorCodigo) {
                    maiorCodigo = codigoAtual;
                }
            }
        }

        return maiorCodigo + 1;
    }

    // apagarCliente
    public static String[][] apagarClientes(String[][] clientes, Scanner sc) {

        System.out.println("Código do Cliente a ser deleteado: ");
        String codg = pedirTexto(sc);
        int codigoTransformadoEmNumero = Integer.parseInt(codg);
        int k = 0;
        boolean encontrado = false;

        if (codigoTransformadoEmNumero <= 0) {
            System.out.println("Código Zero ou abaixo de Zero é inválido");;
            System.out.println("");
            return clientes;
        }

        for (int i = 0; i < clientes.length; i++) {
            if (codg.equals(clientes[i][0])) {
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente não encontrado");
            return clientes;
        }

        String[][] novaCliente = new String[clientes.length - 1][8];

        for (int i = 0; i < clientes.length; i++) {

            if (codg.equals(clientes[i][0])) {
                continue;
            }

            for (int j = 0; j < clientes[i].length; j++) {
                novaCliente[k][j] = clientes[i][j];
            }

            k++;
        }

        return novaCliente;
    }

    // ordenarClientesPorNome
    public static void ordenarClientesPorNome(String[][] clientes) {
        for (int i = 0; i < clientes.length - 1; i++) {
            for (int j = 0; j < clientes.length - 1 - i; j++) {
                if (compararNomeCharPorChar(clientes[j][1], clientes[j + 1][1]) > 0) {
                    trocarLinhas(clientes, j, j + 1);
                }
            }
        }
        System.out.println("Clientes ordenados por nome!");
        listarClientes(clientes);
    }

    // ========== CONTATOS ==========
    public static String[][] aumentarMatrizContatos(String[][] matrizContatos) {
        int novaLinha = matrizContatos.length + 1;
        String[][] novaMatriz = new String[novaLinha][5];
        for (int i = 0; i < matrizContatos.length; i++) {
            for (int j = 0; j < matrizContatos[i].length; j++) {
                novaMatriz[i][j] = matrizContatos[i][j];
            }
        }
        return novaMatriz;
    }

    //incluirContato
    public static void incluirContato(String[][] contatos, Scanner input, int limitadorMatriz, String[][] clientes) {
        int i = limitadorMatriz;

        for (int j = 0; j < contatos[i].length; j++) {
            switch (j) {
                case 0:
                    contatos[i][j] = String.valueOf(gerarNovoCodigoContato(contatos));
                    break;
                case 1:
                    String codigoCliente = "";
                    do {
                        System.out.println("Código do Cliente: ");
                        codigoCliente = input.nextLine();

                        int indice = -1;

                        for (int k = 0; k < clientes.length; k++) {
                            if (clientes[k][0] != null && codigoCliente.equals(clientes[k][0])) {
                                indice = k;
                                break;
                            }
                        }

                        if (indice == -1) {
                            System.out.println("Cliente não encontrado.");
                            codigoCliente = "";
                        }

                    } while (codigoCliente.equals(""));

                    contatos[i][j] = codigoCliente;
                    break;
                case 2:
                    System.out.println("Tipo (ex: EMAIL, TELEFONE, CELULAR): ");
                    contatos[i][j] = input.nextLine().toUpperCase();
                    break;
                case 3:
                    System.out.println("Valor (ex: email@gmail.com / (11) 99999-9999): ");
                    contatos[i][j] = input.nextLine();
                    break;
                case 4:
                    System.out.println("Status (ATIVO/INATIVO): ");
                    contatos[i][j] = input.nextLine().toUpperCase();
                    break;
            }
        }
    }

    public static void imprimirCabecalhoContatos() {
        System.out.printf("%-15s | %-13s | %-15s | %-22s | %-10s%n",
                "CodigoContato", "CodigoCliente", "Tipo", "Valor", "Status");
        System.out.println("-----------------+-----------------+-----------------+------------------------+------------");
    }

    //listarContatosTabela
    public static void listarContatos(String[][] contatos) {
        imprimirCabecalhoContatos();
        for (int i = 0; i < contatos.length; i++) {
            System.out.printf("%-15s | %-13s | %-15s | %-22s | %-10s%n",
                    contatos[i][0], // CodigoContato
                    contatos[i][1], // CodigoCliente
                    contatos[i][2], // Tipo
                    contatos[i][3], // Valor
                    contatos[i][4] // Status

            );
        }
    }

    //listarContatosPorCliente
    public static void listarContatosPorCliente(String clientes[][], String[][] contatos, Scanner inputText) {
        System.out.println("Código Cliente: ");
        String cdg = pedirTexto(inputText);

        boolean clienteEncontrado = false;

        for (int i = 0; i < clientes.length; i++) {
            if (cdg.equals(clientes[i][0])) {
                clienteEncontrado = true;
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        imprimirCabecalhoContatos();
        for (int i = 0; i < contatos.length; i++) {
            if (cdg.equals(contatos[i][1])) { // coluna 1 = CodigoCliente
                System.out.printf("%-15s | %-13s | %-15s | %-22s | %-10s%n",
                        contatos[i][0],
                        contatos[i][1],
                        contatos[i][2],
                        contatos[i][3],
                        contatos[i][4]
                );
            }
        }
    }

    //alterarContato
    public static void alterarContato(String[][] contatos, Scanner InputText) {
        listarContatos(contatos);
        System.out.println("Qual Contato deseja Alterar =>");
        String codigoDoContatoAlterar = InputText.nextLine();
        boolean valid = false;
        for (int i = 0; i < contatos.length; i++) {
            for (int j = 0; j < contatos[i].length; j++) {
                if (codigoDoContatoAlterar.equals(contatos[i][0])) {
                    valid = true;
                    System.out.println("Contato Encontrado:");
                    imprimirCabecalhoContatos();
                    System.out.printf("%-15s | %-13s | %-15s | %-22s | %-10s%n", contatos[i][0], contatos[i][1], contatos[i][2], contatos[i][3], contatos[i][4]);
                    System.out.println("Deseja trocar esse contato?(S/N)");
                    char decisao = InputText.next().charAt(0);
                    InputText.nextLine();
                    if (decisao == 'S' || decisao == 's') {
                        System.out.println("Digite os novos Dados: ");
                        System.out.print("Tipo: ");
                        contatos[i][2] = InputText.nextLine();
                        System.out.print("Valor: ");
                        contatos[i][3] = InputText.nextLine();
                        break;
                    } else {
                        System.out.println("Saindo da alteração...");
                        break;
                    }
                }
            }
        }
        if (!valid) {
            System.out.println("Contato não encontrado...");
        }
    }

    public static int gerarNovoCodigoContato(String[][] contatos) {

        int maiorCodigo = 0;

        for (int i = 0; i < contatos.length; i++) {

            if (contatos[i][0] != null) {

                int codigoAtual = Integer.parseInt(contatos[i][0]);

                if (codigoAtual > maiorCodigo) {
                    maiorCodigo = codigoAtual;
                }
            }
        }

        return maiorCodigo + 1;
    }

    //apagarContato
    public static String[][] apagarContato(String[][] contatos, Scanner InputText) {
        if (contatos.length == 0) {
            System.out.println("Nenhum contato cadastrado.");
            return contatos;
        }

        listarContatos(contatos);
        String[][] novoContato = new String[contatos.length - 1][contatos[0].length];
        System.out.println("Qual contato deseja apagar => ");
        String codigoApagar = InputText.nextLine();
        for (int i = 0; i < contatos.length; i++) {
            if (codigoApagar.equals(contatos[i][0])) {
                System.out.println("Contato Encontrado:");
                imprimirCabecalhoContatos();
                System.out.printf("%-15s | %-13s | %-15s | %-22s | %-10s%n", contatos[i][0], contatos[i][1], contatos[i][2], contatos[i][3], contatos[i][4]);
                System.out.println("Confirmar Exclusão?(S/N)");
                char decisao = InputText.next().charAt(0);
                InputText.nextLine();
                if (decisao == 's' || decisao == 'S') {
                    int novoIndexador = 0;
                    for (int j = 0; j < contatos.length; j++) {
                        if (j != i) {
                            for (int k = 0; k < contatos[j].length; k++) {
                                novoContato[novoIndexador][k] = contatos[j][k];
                            }
                            novoIndexador++;
                        }
                    }
                    return novoContato;
                } else {
                    System.out.println("Saindo da exclusão");
                }
            }
        }
        System.out.println("Contato não encontrado...");
        return contatos;
    }

    //RELATORIOS
    //relatorioPorCliente
    public static void relatorioPorCliente(String[][] clientesMatriz, String[][] contantosMatriz) {
        int cClientes = clientesMatriz.length;
        int cContatos = contantosMatriz.length;
        for (int i = 0; i < clientesMatriz.length; i++) {
            for (int j = 0; j < contantosMatriz.length; j++) {
                if (clientesMatriz[i][0].equals(contantosMatriz[j][1])) {
                    imprimirCabecalhoClientes();
                    imprimirLinha(clientesMatriz[i]);
                    int cContatoClienteAtual = 0;
                    for (int x = 0; x < contantosMatriz.length; x++) {
                        if (clientesMatriz[i][0].equals(contantosMatriz[x][1])) {
                            cContatoClienteAtual++;
                        }
                    }
                    System.out.println("Total de contatos do cliente: " + cContatoClienteAtual);
                    System.out.println(" ");
                }
            }
        }
        System.out.println("Total de clientes: " + cClientes);
        System.out.println("Total de contatos: " + cContatos);
    }

    //Sumarização de dados
    public static void sumarizaçãoDeDados(String[][] matrizClientes, String[][] matrizContatos, int tamanhoCliente, int tamanhoContato) {
        int cClientes = tamanhoCliente, cContatos = tamanhoContato, clientesSemContato = 0;
        float mediaContatos = 0;
        if (cContatos == 0) {
            mediaContatos = 0;
        } else {
            mediaContatos = (float)  cContatos / cClientes;
        }
        for (int i = 0; i < matrizClientes.length; i++) {
            int tempC = 0;
            for (int j = 0; j < matrizContatos.length; j++) {
                if (matrizClientes[i][0].equals(matrizContatos[j][1])) {
                    tempC++;
                }
            }
            if (tempC == 0) {
                clientesSemContato++;
            }
        }
        System.out.println("Total de Clientes: " + cClientes);
        System.out.println("Total de Contatos: " + cContatos);
        System.out.printf("Media de Contatos por Cliente: %.0f\n", mediaContatos);
        System.out.println("Total de clientes sem contatos: " + clientesSemContato);
    }

    // ========== AUXILIARES ==========
    // compararNomeCharPorChar
    public static int compararNomeCharPorChar(String nome1, String nome2) {
        for (int i = 0; i < nome1.length() && i < nome2.length(); i++) {
            if (nome1.charAt(i) < nome2.charAt(i)) {
                return -1;
            } else if (nome1.charAt(i) > nome2.charAt(i)) {
                return 1;
            }
        }
        if (nome1.length() < nome2.length()) {
            return -1;
        } else if (nome1.length() > nome2.length()) {
            return 1;
        }
        return 0;
    }

    // copiarLinha
    public static String[] copiarLinha(String[] linha) {
        String[] copia = new String[linha.length];
        for (int i = 0; i < linha.length; i++) {
            copia[i] = linha[i];
        }
        return copia;
    }

    // limparLinha
    public static void limparLinha(String[] linha) {
        for (int i = 0; i < linha.length; i++) {
            linha[i] = null;
        }
    }

    // trocarLinhas
    public static void trocarLinhas(String[][] matriz, int linha1, int linha2) {
        String[] temp = copiarLinha(matriz[linha1]);
        for (int j = 0; j < matriz[linha1].length; j++) {
            matriz[linha1][j] = matriz[linha2][j];
        }
        for (int j = 0; j < matriz[linha2].length; j++) {
            matriz[linha2][j] = temp[j];
        }
    }
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
