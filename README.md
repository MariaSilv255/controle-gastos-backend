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
- Cadastro
- Listagem
- Atualização
- Remoção

### Despesas
- CRUD completo
- Associação com usuário e categoria
- Filtro por período:

### Integração com WhatsApp
O usuário pode cadastrar uma despesa enviando uma mensagem como:
```# VALOR CATEGORIA
    250 LUZ
```

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

| Método | Endpoint       | Descrição            |
|-------|----------------|----------------------|
| GET   | /usuarios      | Listar usuários      |
| POST  | /usuarios      | Criar usuário        |
| GET   | /usuarios/{id} | Buscar por ID        |
| PUT   | /usuarios/{id} | Atualizar usuário    |
| DELETE| /usuarios/{id} | Remover usuário      |

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

### Categoria

| Método | Endpoint        | Descrição                    |
|-------|-----------------|------------------------------|
| GET   | /categorias     | Listar categorias              |
| POST  | /categorias         | Criar categorias                |
| GET   | /categorias/{id}    | Buscar categorias por ID        |
| PUT   | /categorias/{id}    | Atualizar categorias            |
| DELETE| /categorias/{id}    | Remover categorias              |


# Como executar o projeto
## Baixar o projeto
```
# clonar repositório
git clone https://github.com/MariaSilv255/controle-gastos-backend

# entrar na pasta do projeto back end
cd controle-gastos-backend

# executar o projeto
IntelliJ → File → Open → selecione a pasta controle-gastos-backend

```
## instalação Ngrok
Para permitir que o Twilio acesse o backend local

```
# Para permitir que o Twilio acesse o backend local
ngrok http 8080

# copie a URL gerada em Forwarding, exemplo:
https://unrude-unshavable-maia.ngrok-free.dev

```

## conta twilio 
crie a conta e acesse o painel
```
# crie a conta
https://console.twilio.com/

# acesse o painel e vá em:
 Messaging → Try it out → Send a WhatsApp message (Sandbox settings)
```
### Configuração do webHook
```
# No campo "When a message comes in" cole e salve:
https://unrude-unshavable-maia.ngrok-free.dev/webhook/whatsapp
```

### conectar WhatsApp ao sandbox
Na aba do Sandbox, leia o QR Code ou envie uma mensagem para o número indicado pelo Twilio com o código fornecido.
```
join codigo-aqui

```

## Configurar variáveis no projeto

No arquivo `application-local.properties` (ou `application.properties`), adicione:
Os codigo é encontrado em "Business-Initiated message" nas variaveis ACCOUNT_SID e AUTH_TOKEN
```
twilio.accountSid=SEU_ACCOUNT_SID
twilio.authToken=SEU_AUTH_TOKEN
twilio.whatsappFrom=whatsapp:+14155238886
```
Após isso, o bot já estará pronto para receber mensagens via WhatsApp.


## ️ Limitação do Twilio Sandbox (Conta gratuita)

Este projeto utiliza o **Twilio WhatsApp Sandbox**, que possui restrições importantes na versão gratuita.

Atualmente, o Twilio informa a seguinte limitação:

- O Sandbox utiliza um número de teste dos **Estados Unidos**  
  (exemplo: `+1 415 523 8886`)

- Ao tentar enviar mensagens para números de outros países, como o Brasil (`+55`), o Twilio pode bloquear a entrega por **restrições comerciais e regionais**.

Por isso:

- A mensagem aparece no painel como **Outgoing API**
- Porém ela **não chega no WhatsApp**
- E nenhuma requisição aparece no webhook, porque a mensagem **nem chega a ser entregue**
