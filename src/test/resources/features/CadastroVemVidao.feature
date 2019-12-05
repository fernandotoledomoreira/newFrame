# language: pt

Funcionalidade: Cadastro no site Elo
	Eu como portador de um cartão Caixa Elo
	Desejo me cadastrar no Site Elo
	Para ter acesso às vantagens do cliente
	
	Contexto:
		Dado que estou na tela de cadastro
	
    @cadastroVemVidao
	Esquema do Cenário: Validar cadastro de usuário com sucesso informando um cartão - Campanha Vem Vidão
		Quando preencho os dados da primeira etapa
		|Nome Completo		  	|<Nome>  				|
		|CPF					|<CPF> 					|
		|E-mail					|<E-mail>				|
		|Confirmação de e-mail	|<Confirmação E-mail>	|
		|Criar Senha			|<Senha>				|
		|Repetir senha			|<Repetir Senha>  		|
		E finalizo a segunda etapa
		|Número do cartão		|<Número do Cartão>		|
		|Mês					|<Mês>		  			|
		|Ano					|<Ano>					|
		|Celular				|<Celular>				|
		Entao a mensagem "Cadastro realizado com sucesso!" é exibida
		
		Exemplos:
    	|Nome			|CPF            	|E-mail    					    |Confirmação E-mail			  |Senha		|Repetir Senha	|Número do Cartão		|Mês		|Ano	|Celular		|  
    	|Teste Yaman	|997.286.430-80 	|testeyaman@teste-hotmail.com 	|testeyaman@teste-hotmail.com |Teste@123	|Teste@123		|6550 0800 0000 0009	|Janeiro	|2021	|1899122-2941	|


	@CadastroSemCartaoVemVidao
	Esquema do Cenário: Validar cadastro de usuário com sucesso sem informar um cartão - Campanha Vem Vidão
		Quando preencho os dados da primeira etapa
		|Nome Completo		  	|<Nome>  				|
		|CPF					|<CPF> 					|
		|E-mail					|<E-mail>				|
		|Confirmação de e-mail	|<Confirmação E-mail>	|
		|Criar Senha			|<Senha>				|
		|Repetir senha			|<Repetir Senha>  		|
		E finalizo a segunda etapa sem preencher os dados do cartão
		Entao a mensagem "Cadastro realizado com sucesso!" é exibida
		
		Exemplos:
    	|Nome			|CPF            |E-mail    					|Confirmação E-mail			|Senha		|Repetir Senha	|  
    	|Teste Yaman	|575.631.770-86 |testeyaman@testes.com.uk 	|testeyaman@testes.com.uk	|Teste@123	|Teste@123		|

 


  @CadastroDadosInvalidos
	Esquema do Cenário: Validar cadastro com <Informações> inválido/as na etapa de cadastro de usuário - Campanha Vem Vidão
		Quando preencho os dados da primeira etapa
		|Nome Completo		  	|<Nome>  				|
		|CPF					|<CPF> 					|
		|E-mail					|<E-mail>				|
		|Confirmação de e-mail	|<Confirmação E-mail>	|
		|Criar Senha			|<Senha>				|
		|Repetir senha			|<Repetir Senha>  		|
		Entao exibe a mensagem de erro "<Mensagem>"
		
		Exemplos:
    	|Nome			|CPF            |E-mail    					|Confirmação E-mail			|Senha		|Repetir Senha	|Mensagem																							|Informações						|
    	|Teste Yaman	|222.222.222.22 |testeyaman@teste.com.uk 	|testeyaman@teste.com.uk	|Teste@123	|Teste@123		|Ops! Seu CPF parece ser inválido. Verifique se preencheu corretamente este campo					|CPF 								|
    	|Teste 			|096.264.730-61 |testeyaman@teste.com.uk 	|testeyaman@teste.com.uk	|Teste@123	|Teste@123		|Ops! Seu Nome não tem um formato aceito. Verifique se preencheu corretamente este campo			|formato de nome 					|
    	|Teste Yaman	|096.264.730-61 |testeyaman@t				|testeyaman@teste.com.uk	|Teste@123	|Teste@123		|Ops! Todos os campos devem ser preenchidos. Verifique se preencheu corretamente este formulário	|E-mail com formato 				|
    	|Teste Yaman	|096.264.730-61 |testeyaman@teste.com.uk 	|testeyaman@te				|Teste@123	|Teste@123		|Ops! Seu Email não tem um formato aceito. Verifique se preencheu corretamente este campo			|Confirmação de e-mail com formato 	|
    	|Teste Yaman	|096.264.730-61 |testeyaman@teste.com.uk 	|testeyaman@teste.com.uk	|Teste@123	|Teste			|Ops! Todos os campos devem ser preenchidos. Verifique se preencheu corretamente este formulário	|Confirmação de senha 				|
    	|Teste Yaman	|096.264.730-61 |testeyaman@teste.com.uk 	|testeyaman@teste.com.uk	|Teste		|Teste			|Ops! Todos os campos devem ser preenchidos. Verifique se preencheu corretamente este formulário	|Formato de senha 					|
    
  @CadastroDadosEmBranco
	Esquema do Cenário: Validar cadastro com <Informações> em branco na etapa de cadastro de usuário
		Quando preencho os dados da primeira etapa
		|Nome Completo		  	|<Nome>  				|
		|CPF					|<CPF> 					|
		|E-mail					|<E-mail>				|
		|Confirmação de e-mail	|<Confirmação E-mail>	|
		|Criar Senha			|<Senha>				|
		|Repetir senha			|<Repetir Senha>  		|
		Entao exibe a mensagem de erro "<Mensagem>" no campo
		
		Exemplos:
	  	|Nome			|CPF            |E-mail    					|Confirmação E-mail			|Senha		|Repetir Senha	|Mensagem								|Informações			|
	  	|				|217.496.960-29 |testeyaman@teste.com.uk 	|testeyaman@teste.com.uk	|Teste@123	|Teste@123		|Confira o campo Nome completo			|nome					|
	  	|Teste Yaman	|				|testeyaman@teste.com.uk 	|testeyaman@teste.com.uk	|Teste@123	|Teste@123		|Confira o campo CPF					|CPF					|
	  	|Teste Yaman	|217.496.960-29	|							|testeyaman@teste.com.uk	|Teste@123	|Teste@123		|Confira o campo E-mail					|e-mail					|								
	  	|Teste Yaman	|217.496.960-29	|testeyaman@teste.com.uk 	|							|Teste@123	|Teste@123		|Confira o campo Confirmar e-mail		|confirmação de e-mail	|
	  	|Teste Yaman	|217.496.960-29	|testeyaman@teste.com.uk 	|testeyaman@teste.com.uk	|Teste@123	|				|Confira o campo Criar senha			|senha					|
	  	|Teste Yaman	|217.496.960-29	|testeyaman@teste.com.uk 	|testeyaman@teste.com.uk	|			|Teste@123		|Confira o campo Repetir senha			|confirmação de senha 	|
	  
	