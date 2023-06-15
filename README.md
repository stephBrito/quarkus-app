# Quotes Dollar - BCB

API para consultar cotação da moeda americana dólar, utilizando um campo de data no formato
(mes="MM"-dia="dd"-ano="yyyy"). Também, possui a funcionalidade de armazenar as pesquisar realizadas
e consulta-las posteriormente.


## Ferramentas utilizadas
JAVA Quarkus e Maven foram as principais ferramentas usadas na construção desta API.
- Hibernate e JPA para conexão com o PostgreDB, usado para persistência dos dados das informações.
- IDE utilizada foi o IntelliJ.
- Documentação com Swagger-Ui e OpenAPI.

## Setup
Antes de tudo é necessário ter uma instância do PostgreDB localmente/ou container 
de preferência executando na porta 'b'5432'/b'. É possível utilizar o Docker para esse 
mesmo fim; para um passo-a-passo sobre o assunto, [recomendo a leitura deste artigo](https://medium.com/@renato.groffe/docker-nosql-executando-o-mongodb-e-o-redis-a-partir-de-containers-3c143e920f09).

## Rotas/endpoints (como usar)

Consulta cotação por data específica:
```
[GET] /v1/dollar/quotesbyperiod?datetimeQuote={datetimeQuote}
@QueryParameter(datetimeQuote) = (MM-dd-yyyy)
```

Retorna todas as cotações solicitadas e armazenadas no banco de dados
```
[GET] /v1/dollar/getallsavedquotes
```

## Execução e empacotamento

Para empacotamento, execute o comando:
```shell script
./mvnw package
```

Para subir uma instância da API, dirija-se à pasta "/target" e execute o comando a seguir:
```
java -jar <arquivo_compilado>.jar
```

Para subir os container do projeto, a aplicação conta com um arquivo docker-compose.
Execute o script abaixo de dentro do diretório da aplicação.
```shell script
 docker-compose up --build
```
ou
```shell script
 docker-compose up -d
```

### Recomendação Padrão
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Executando a aplicação em modo DEV

Você pode executar a aplicação utilizando o comando abaixo, iniciando um terminal no caminho
em que foi realizado o download do projeto.
```shell script
./mvnw compile quarkus:dev
```

OBS: atente-se às configurações de ambiente (application.properties); caso seja necessário,
pode-se copiar o arquivo correspondente às configurações para a mesma pasta do 
arquivo .jar a ser executado.


## Considerações finais e Especificações

É possível ter essa solução on-premises, mas devido ao alto custo de gerenciamento, recomento uma solução cloud que dê suporte a cloud services (AWS Beanstalk, Azure App Service, etc) 
ou até mesmo conteinerização (Docker), maximizando o poder de gestão de capacity sem a preocupação com os recursos subjacentes.

- Recomendo em conjunto uma solução de CI/CD como Jenkins, Gitlab CI, Microsoft Azure ou GCP.
- As especificações encontram-se [aqui](ApplicationCase.MD)

## Guia para desenvolvimento

- Micrometer Registry Prometheus ([guide](https://quarkus.io/guides/micrometer)): Enable Prometheus support for Micrometer
- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A JAX-RS implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
