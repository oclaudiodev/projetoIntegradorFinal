# Projeto Integrador Final

Sistema de gerenciamento de clientes e contatos desenvolvido em Java, com interface via terminal. Permite cadastrar, listar, buscar, alterar, apagar e ordenar clientes e seus respectivos contatos, além de gerar relatórios e carregar dados de arquivos CSV.

---

## Funcionalidades

### Clientes
- Incluir novo cliente
- Listar todos os clientes
- Consultar cliente por código
- Alterar dados de um cliente
- Apagar cliente
- Ordenar clientes por nome (Bubble Sort)

### Contatos
- Incluir novo contato (vinculado a um cliente)
- Listar todos os contatos
- Listar contatos de um cliente específico
- Alterar contato
- Apagar contato

### Relatórios
- Listar clientes com total de contatos por cliente
- Sumarização de dados: total de clientes, total de contatos, média de contatos por cliente e clientes sem contato

### Outros
- Carregamento de dados de teste via arquivos CSV (clientes.csv e contatos.csv)

---

## Estrutura dos Dados

### Cliente (clientes.csv)
| Campo            | Descricao                  |
|------------------|----------------------------|
| codigo           | Identificador unico        |
| nome             | Nome completo              |
| cpf_cnpj         | CPF ou CNPJ                |
| data_nascimento  | Data de nascimento         |
| sexo             | M ou F                     |
| cidade           | Cidade                     |
| estado           | Estado                     |
| status           | ATIVO / INATIVO            |

### Contato (contatos.csv)
| Campo           | Descricao                          |
|-----------------|------------------------------------|
| codigo_contato  | Identificador unico                |
| codigo_cliente  | Codigo do cliente vinculado        |
| tipo            | EMAIL, TELEFONE ou CELULAR         |
| valor           | O dado do contato (ex: email@...)  |
| status          | ATIVO / INATIVO                    |

---

## Como Executar

### Pre-requisitos
- Java JDK 8 ou superior instalado

### Compilar
```bash
javac projetointegradorfinal/ProjetoIntegradorFinal.java
```

### Executar
```bash
java projetointegradorfinal.ProjetoIntegradorFinal
```

### Carregar dados de teste (opcional)
Coloque os arquivos clientes.csv e contatos.csv na raiz do projeto e selecione a opcao 4 - Carregar dados de teste (CSV) no menu principal.

Exemplo de clientes.csv:
```
codigo,nome,cpf_cnpj,data_nascimento,sexo,cidade,estado,status
1,Joao Silva,123.456.789-00,01/01/1990,M,Sao Paulo,SP,ATIVO
```

Exemplo de contatos.csv:
```
codigo_contato,codigo_cliente,tipo,valor,status
1,1,EMAIL,joao@email.com,ATIVO
```

---

## Menu Principal

```
1 - Gerenciar clientes
2 - Gerenciar contatos
3 - Relatorios
4 - Carregar dados de teste (CSV)
0 - Sair
```

---

## Tecnologias

- Java (sem dependencias externas)
- Estruturas de dados com matrizes bidimensionais (String[][])
- Leitura de arquivos com BufferedReader e FileReader
- Interface via terminal com Scanner

---

## Estrutura do Projeto

```
projetointegradorfinal/
└── ProjetoIntegradorFinal.java
clientes.csv       (opcional, para dados de teste)
contatos.csv       (opcional, para dados de teste)
```
