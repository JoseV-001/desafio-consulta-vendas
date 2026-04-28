# Desafio: Consulta de Vendas

Este repositório contém a implementação do desafio proposto no curso DevSuperior.

## Sobre o desafio

O objetivo foi implementar consultas utilizando **JPA, SQL e JPQL** em um sistema de vendas com as entidades:

* **Sale (Venda)**
* **Seller (Vendedor)**

Um vendedor pode ter várias vendas, e cada venda pertence a um vendedor.

## Funcionalidades

### Relatório de vendas

Consulta paginada de vendas com filtros opcionais:

* Data inicial
* Data final
* Nome do vendedor

Retorna:

* ID
* Data
* Valor da venda
* Nome do vendedor

### Sumário de vendas por vendedor

Consulta que retorna o total de vendas agrupado por vendedor em um período.

## Regras

* Se a data final não for informada → usa a data atual
* Se a data inicial não for informada → considera 1 ano antes da data final
* Se o nome não for informado → considera vazio
* Tratamento realizado na camada de service

## Tecnologias utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Banco de dados H2

## Como executar o projeto

```bash
# Clonar repositório
git clone <seu-link-aqui>

# Entrar na pasta
cd nome-do-projeto

# Rodar o projeto
./mvnw spring-boot:run
```

## Observação

Este projeto foi desenvolvido com fins educacionais como parte do curso DevSuperior.
Trata-se de um fork do projeto original, utilizado para prática dos conceitos apresentados.
