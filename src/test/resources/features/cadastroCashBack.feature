# language: pt

Funcionalidade: Cadastro no site Elo
	Eu como portador de um cartão Pernambucanas Elo
	Desejo me cadastrar no Site Elo
	Para ter acesso às vantagens do cliente
	
	
    @cadastroCashBack
	Esquema do Cenário: Validar cadastro de usuário com sucesso informando um cartão - Cash Back
		Quando preencho os dados para cadastro cash back "<Nome>", "<CPF>", "<E-mail>", "<Senha>", "<RepetirSenha>", "<Cartao>", "<Mes>" , "<Ano>" "<Celular>"
		Entao a mensagem "Olá Yaman, " é exibida para cash back
		
		Exemplos:
    	|Nome	|CPF            	|E-mail    					    |Senha		|RepetirSenha	| Cartao		        |Mes		|Ano	|Celular		|  
    	|Yaman	|363.401.970-00 	|testeyaman@teste-hotmail.com 	|Teste@123	|Teste@123		|6550 1250 0934 6129	|3      	|2022	|1899122-2941	|

  