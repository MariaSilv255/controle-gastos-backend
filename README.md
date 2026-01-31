# Controle de Gastos Backend — API REST com Integração WhatsApp
Projeto backend desenvolvido em **Java com Spring Boot**, com o objetivo de gerenciar despesas pessoais e permitir o cadastro automático de gastos via mensagens no WhatsApp utilizando **Twilio Webhook**.

---
## Objetivo do Projeto

Este projeto foi criado para estudar e aplicar conceitos fundamentais do desenvolvimento backend:

- API REST com Spring Boot
- CRUD completo
- Relacionamentos entre entidades (Usuário, Despesa, Categoria)
- Tratamento centralizado de exceções
- DTOs para segurança e organização
- Integração com WhatsApp via Webhook (Twilio)

---
## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL / H2 (ambiente de testes)
- Maven
- DTO Pattern
- Twilio API (WhatsApp Sandbox)
- Ngrok (para expor o servidor local)

---
## Funcionalidades Implementadas

### Usuários
- Cadastro de usuários
- Listagem
- Atualização
- Remoção

### Categorias
- Cadastro e organização de despesas por categoria

### Despesas
- CRUD completo
- Associação com usuário e categoria
- Filtro por período:

### Integração com WhatsApp
O usuário pode cadastrar uma despesa enviando uma mensagem como:
```55 alimentacao```

O sistema interpreta localizando o usuario pelo numero do telefone e salva automaticamente no banco.

---
## Estrutura do Projeto
```
│
├── entities
│ ├── Usuario.java
│ ├── Despesa.java
│ └── Categoria.java
│
├── repositories
│ ├── UsuarioRepository.java
│ ├── DespesaRepository.java
│ └── CategoriaRepository.java
│
├── services
│ ├── UsuarioService.java
│ ├── DespesaService.java
│ ├── CategoriaService.java
│ └── WhatsAppService.java
│
├── resources (Controllers)
│ ├── UsuarioResource.java
│ ├── DespesaResource.java
│ ├── CategoriaResource.java
│ └── WhatsAppWebhookResource.java
│
├── DTO
│ ├── UsuarioDTO.java
│ └── WhatsAppMessageDTO.java
│
└── exceptions
├── ResourceNotFoundException.java
└── ResourceExceptionHandler.java
```

## Relacionamentos do Sistema

```
USUARIO 1 ----- n DESPESAS n ------ 1 Categoria
```

## Endpoints 

### Usuários

| Método | Endpoint        | Descrição            |
|-------|----------------|----------------------|
| GET   | /usuario        | Listar usuários      |
| POST  | /usuario        | Criar usuário        |
| GET   | /usuario/{id}   | Buscar por ID        |
| PUT   | /usuario/{id}   | Atualizar usuário    |
| DELETE| /usuario/{id}   | Remover usuário      |

---

### Despesas

| Método | Endpoint                 | Descrição                    |
|-------|--------------------------|------------------------------|
| GET   | /gastos                  | Listar despesas              |
| POST  | /gastos                  | Criar despesa                |
| GET   | /gastos/{id}             | Buscar despesa por ID        |
| PUT   | /gastos/{id}             | Atualizar despesa            |
| DELETE| /gastos/{id}             | Remover despesa              |
| GET   | /gastos/periodo          | Filtrar por período          |
