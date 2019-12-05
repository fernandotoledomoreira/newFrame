# language: pt

Funcionalidade: Cadastro no site Elo
	Eu como portador de um cartão caixa Elo
	Desejo me cadastrar no Site Elo
	Para ter acesso às vantagens do cliente
	
	
    @cadastroCaixaHabitacional
	Esquema do Cenário: Validar cadastro de usuário com sucesso informando um cartão - Caixa Habitacional
		Quando preencho os dados para cadastro caixa habitacional "<Nome>", "<CPF>", "<E-mail>", "<Senha>", "<RepetirSenha>", "<Cartao>", "<Mes>" , "<Ano>" "<Celular>"
		Entao a mensagem "Olá Yaman, " é exibida para caixa habitacional
		
		Exemplos:
    	|Nome	|CPF            	|E-mail    					    |Senha		|RepetirSenha	| Cartao		        |Mes		|Ano	|Celular		|  
    	|Yaman	|387.892.150-01 	|testeyaman@teste-gmail.com 	|Teste@123	|Teste@123		|6550 0700 0042 9146	|3      	|2022	|1899122-2941	|

  