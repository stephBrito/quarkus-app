### Histórias e definições da aplicação

1 - Eu como provedor de moeda internacional, preciso realizar diariamente
consultas de uma determinada data para saber a cotação comercial da moeda americana (dólar).

2 - Eu como negociador da moeda americana (dólar), preciso que as pesquisas relacionadas a cotação,
sejam armazenadas em uma base própria.

3 - Eu como provedor da moeda americana (dólar), tenho a necessidade de consultar todas as informações
de cotação armazenadas em base própria, para que seja criado um dashboard gráfico com a variação da moeda
para os clientes.

### Critérios de Aceitação
##### --> História 1:
* A consulta deve retornar o valor de negociação da moeda

* A consulta deve ser realizada apenas com uma data escolhida e com a formatação (MM-dd-yyyy).

##### --> História 2:
* As consultas precisam ser armazenadas com um id único, para que seja indexado.

* A data da consulta precisa ser armazenada, assim como a data/hora atual e o TimeSpan de retorno da consulta.

##### --> História 3:
* O retorno deve ser de todo o período consultado e armazenado na base de dados.

### Cenários de Testes
  1 - No momento da primeira consulta na história 1, verificar se o formato da data pode ser diferente do
informado.

  2 - A data da requisição para consultar a cotação do dólar, não deve ser vazia/nula
  
  3 - O payload de retorno deve estar formatado e conter aviso sobre o armazenamento, se ocorreu sucesso ou não no 
  ato do armazenamento na base de dados.
  
  4 - Se o armazenamento das informações estiver ocorrendo de forma correta, deve ser possível utilizar o endpoint 
  de consulta dos dados e ele deve retornar tudo que foi armazenado.
  
  5 - O payload de retorno da lista de cotações deve estar formatado.