# language: pt
# Author: Fernando Toledo Moreira

@login
Funcionalidade: Login no site Elo
	Eu como usuário cadastrado no site Elo
	Desejo acessar minha conta 
	Para consultar e aproveitar as vantagens exclusivas do cliente
	
	
  @LoginSiteElo 
	Esquema do Cenário: Validar login no site elo com dados validos
		Quando realizo login com os dados "<CPF>" e "<Senha>"
		Entao o login foi realizado com sucesso
		
    Exemplos:
    |CPF            |Senha     |  
    |918.843.760-45 |Teste@123 | 
     
   @LoginNegativo 
	Esquema do Cenário: Validar login no site elo com "<Validar>"
		Quando realizo login com os dados "<CPF>" e "<Senha>"
		Entao exibe a seguinte mensagem de erro "<Mensagem>" 
		
    Exemplos:
    | Validar                                    |CPF            |Senha     		| Mensagem															|
    | cpf inválido e fora do padrão              |000.000.760-45 |Teste135* 		|Ops! Seu CPF parece ser inválido.			|
    | senha no padrão mas divergente da castrada |918.843.760-45 |Teste123* 		|Os dados de acesso estão incorretos.	  |
    | senha inválida e fora do padrão            |918.843.760-45 |Teste				  |Senha inválida. 												|
    | dados incorretos e não cadastrados         |389.427.430-13 |CPF_sem_cad*  |Os dados de acesso estão incorretos.   |
    | sem preenchimento de senha                 |918.843.760-45 |							|Ops! Sua senha parece ser inválida.    |
    | sem preenchimento do CPF                   |							 |Teste456@		  |Ops! Seu CPF parece ser inválido.			|
    
    
    
    
    