# language: pt
# Author: Fernando Toledo Moreira


Funcionalidade: Login no site Elo
	Eu como usuário cadastrado no site Elo
	Desejo acessar minha conta 
	Para consultar e aproveitar as vantagens exclusivas do cliente
	
	
  @LoginCashBack
	Esquema do Cenário: Validar login no site elo com dados validos - Cash Back
		Quando realizo login com os dados "<CPF>" e "<Senha>" no site cash back
		Entao o login foi realizado com sucesso no site cash back
		
    Exemplos:
    |CPF            |Senha     |  
    |423.960.990-94 |Teste@123 | 
     
   @LoginNegativoCashBack 
	Esquema do Cenário: Validar login no site elo com <Validar> - Cash Back
		Quando realizo login com os dados "<CPF>" e "<Senha>" no site cash back
		Entao exibe a seguinte mensagem de erro "<Mensagem>" no site cash back
		
    Exemplos:
    | Validar                                    |CPF            |Senha     	 | Mensagem				                              			                |
    | cpf inválido e fora do padrão              |000.000.760-45 |Teste@123 	 |Insira um CPF válido!	                                              |
    | senha no padrão mas divergente da castrada |423.960.990-94 |Teste123* 	 |Ops! Não conseguimos identificar o CPF ou a senha que você digitou. |
    | senha inválida e fora do padrão            |423.960.990-94 |Teste		     |Insira pelo menos 8 caráteres. 					                            |
    | dados incorretos e não cadastrados         |389.427.430-13 |CPF_sem_cad* |Ops! Não conseguimos identificar o CPF ou a senha que você digitou. |
    | sem preenchimento de senha                 |423.960.990-94 |				     |Campo obrigatório                                                   |
    | sem preenchimento do CPF                   |				       |Teste456@		 |Campo obrigatório	                                                  |
    
    
    
    
    