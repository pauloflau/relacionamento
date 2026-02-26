# Projeto Pessoa/Departamento (Spring Boot)

Este projeto é um exemplo simples de aplicação **Spring Boot** com **JPA/Hibernate**, mostrando como trabalhar com **entidades relacionadas**, **DTOs** e **endpoints REST**.

---

## 📌 Tecnologias usadas
- Java 17+  
- Spring Boot  
- Spring Data JPA  
- H2 Database (ou outro banco configurado)  
- Maven  

---

## 📂 Estrutura principal

- **Pessoa** → Entidade que representa uma pessoa, com `nome`, `salário` e vínculo a um **Departamento**.  
- **Departamento** → Entidade que representa o departamento da empresa.  
- **PessoaDepartamentoDto** → DTO usado para transferir dados da `Pessoa` junto com o `Departamento`.  
- **PessoaService** → Contém a lógica de negócio (inserção de pessoa).  
- **PessoaController** → Expõe endpoints REST para manipular pessoas.  

---

## ⚙️ Funcionalidade implementada

### ➡️ Criar uma nova pessoa
**POST** `/pessoa`

#### Exemplo de requisição:
```json
{
  "nome": "João da Silva",
  "salario": 4500.00,
  "departamento": {
    "id": 1
  }
}
```

### Exemplo de resposta:
```json
{
  "id": 1,
  "nome": "João da Silva",
  "salario": 4500.00,
  "departamento": {
    "id": 1,
    "nome": "TI"
  }
}
```
### 🛠️ Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/paulo/relacionamento.git
   ```
2. Entre no diretorio do projeto:
   ```bash
    cd seu-repo
   ```
3. Acesso no navegador ou via Postman:
   ```bash
    http://localhost:8080/pessoa
   ```

### 🔗 Relacionamento usado
- Uma Pessoa pertence a um Departamento (@ManyToOne).
- O cadastro de pessoa é feito informando apenas o id do departamento existente.

---

## 📧 Contato

Caso queira trocar ideias ou sugerir melhorias:  
**Paulo Flau**
- [LinkedIn](https://www.linkedin.com/in/pauloflau/) 


