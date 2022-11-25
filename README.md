# sales-order-manager
 Test frameworks

#####  #####
Projeto de microsservice que tem como intuito aplicar novos frameworks e padroes de projeto.
Testes com Junit e Mockito.
Conversor de Entidade com MapStruct
Java version 17.

#### #####
Microservice project that aims to apply new standard design frameworks.
Unit Test with Junit and Mockito.
Java version 17
Model mapper entity MapStruct.

port

produto-service
8000 - 8100



OBS: 

Para integracao com a AWS (Gp2) atraves do RDS

è necessario criar uma conta Amazon e seguir com as seguinte configurações:

apos realizar criacao de conta no link -> https://aws.amazon.com/pt/premiumsupport/knowledge-center/create-and-activate-aws-account/

 * Apos criar a conta, clique no search e procure por RDS, depois criar banco de dados ( botao)
 * Escolha criar forma padrao - para que tenha um melhor controle
 * Escolher o banco, neste caso MySQL, edicao community versao MySQL 8.0.28
 * Modelo : nivel gratuito -> lembrando que essa aplicacao é para fins de estudos
 * configuracao - primeiro campo é a instancia, caminho que ira referenciar seu DB, login e senha ( nao se esqueca)
 * configuracao de instancia dê preferencia para  db.t2.micro é mais lento porem mais barato(caso a versao gratuita esteja acabado)
 * Amazenamento gp2 de 20GB, desabilitar escalabilidade pois nao há necessidade, com limite max de 20gb
 * Conectividade: Default VPC, e acesso publico sim ( pois iremos usar nossa aplicacao), caso acesso nao será necessario ferramenta amazon
 * grup  de seguranca, selecionar existente, zona de disponibilidade - sem preferencia
 * autenticacao por senha, para as demais blocos como monitoramento, log não é necessario marcar.
ele vai gerar uam isntancia e na mesma havera uma caminho chamado Endpoint, que será usado para conexao como uma conexao de banco normal


concluido os passo altera o caminho no arquivo .yml da aplicacao 
ex: 
local mysql =  url: jdbc:mysql://localhost:3306/db_products?useTimezone=true&serverTimezone=UTC
AWS mysql  = url: jdbc:msql://endpoint-instancia-criado.amazonaws.com:33006/db_products?useTimezone=true&serverTimezone=UTC


Essa seria a url final