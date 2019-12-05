# language: pt
# Author: Fernando Toledo Moreira


Funcionalidade: Login no site Elo
	Eu como usuário cadastrado no site Elo
	Desejo acessar minha conta 
	Para consultar e aproveitar as vantagens exclusivas do cliente
	
	
  @loginCaixaHabitacional
	Esquema do Cenário: Validar login no site elo com dados validos - Caixa Habitacional
		Quando realizo login com os dados "<CPF>" e "<Senha>" no site caixa habitacional
		Entao o login foi realizado com sucesso no site caixa habitacional
		
    Exemplos:
    |CPF            |Senha     |  
    |761.621.920-91 |Teste@123 | 
     
   @loginNegativoCaixaHabitacional
	Esquema do Cenário: Validar login no site elo com <Validar> - Caixa Habitacional
		Quando realizo login com os dados "<CPF>" e "<Senha>" no site caixa habitacional
		Entao exibe a seguinte mensagem de erro "<Mensagem>" no site caixa habitacional
		
    Exemplos:
    | Validar                                    |CPF            |Senha     	 | Mensagem				                              			                |
    | cpf inválido e fora do padrão              |000.000.760-45 |Teste@123 	 |Insira um CPF válido!	                                              |
    | senha no padrão mas divergente da castrada |761.621.920-91 |Teste123* 	 |Ops! Não conseguimos identificar o CPF ou a senha que você digitou. |
    | senha inválida e fora do padrão            |761.621.920-91 |Teste		     |Insira pelo menos 8 caráteres. 					                            |
    | dados incorretos e não cadastrados         |389.427.430-13 |CPF_sem_cad* |Ops! Não conseguimos identificar o CPF ou a senha que você digitou. |
    | sem preenchimento de senha                 |761.621.920-91 |				     |Campo obrigatório                                                   |
    | sem preenchimento do CPF                   |				       |Teste456@	 	 |Campo obrigatório	                                                  |
    
    
    
    
    