# language: pt

Funcionalidade: Recuperação de senha de cadastro no site Elo
	Eu como usuário cadastrado no site Elo
	Desejo cadastrar meus cartões
	Para usufruir das vantagens do cliente Elo
	
	Contexto:
		Dado que realizei login no site Elo com o CPF "<CPF>" e senha "<Senha>"
	
	@beatriz @cadastroCartao
	Esquema do Cenário: Validar cadastro de cartão 
		Quando cadastro um cartão "<Número do cartão>"
		Entao retorna a mensagem "Cartão cadastrado com sucesso!"

		Exemplos:
    	|CPF            |Senha		|Número do cartão		|
    	|090.724.950-71	|Teste@123	|6550 0000 0000 0002	|
  
  @beatriz @cadastroCartao
	Esquema do Cenário: Validar cadastro de um novo cartão
		Quando cadastro um novo cartão "<Número do cartão>"
		Entao retorna a mensagem "Cartão cadastrado com sucesso!"
		
		Exemplos:
    	|CPF            |Senha		|Número do cartão	    |
    	|090.724.950-71 |Teste@123	|6550 0000 0000 0009	|
    
  @beatriz @cadastroCartao
	Esquema do Cenário: Validar cadastro de um novo cartão com valor inválido
		Quando cadastro um novo cartão "<Número do cartão>"
		Entao retorna a mensagem de erro "Ops! Algo deu errado. Por favor, tente novamente."
				
		Exemplos:
    	|CPF            |Senha		|Número do cartão		|
    	|090.724.950-71 |Teste@123	|0000 0000 0000 0000 	|