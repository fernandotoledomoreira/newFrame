# language: pt

Funcionalidade: Cadastro no site Elo
	Eu como portador de um cartão Elo
	Desejo me cadastrar no Site Elo
	Para ter acesso às vantagens do cliente
	
	Contexto:
		Dado que estou na tela de cadastro
	
	@beatriz @cadastro
	Esquema do Cenário: Cadastro de usuário com sucesso informando um cartão
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
    	|Nome			|CPF            	|E-mail    					|Confirmação E-mail			|Senha		|Repetir Senha	|Número do Cartão		|Mês		|Ano	|Celular		|  
    	|Teste Yaman	|365.513.660-90 	|testeyaman@testes.com.uk 	|testeyaman@testes.com.uk	|Teste@123	|Teste@123		|6550 0000 0000 0009	|Janeiro	|2021	|1899122-2941	|


	@beatriz @cadastro @teste
	Esquema do Cenário: Cadastro de usuário com sucesso sem informar um cartão
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
    	|Teste Yaman	|090.724.950-71 |testeyaman@testes.com.uk 	|testeyaman@testes.com.uk	|Teste@123	|Teste@123		|

 


  @beatriz @cadastro
	Esquema do Cenário: Cadastro com <Informações> inválido/as na etapa de cadastro de usuário
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
    
  @beatriz @cadastro
	Esquema do Cenário: Cadastro com <Informações> em branco na etapa de cadastro de usuário
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
	  
	@beatriz @cadastro
	Esquema do Cenário: Cadastro com <Informações> inválido na etapa de cadastro de cartão
		Quando preencho os dados da primeira etapa
		|Nome Completo		  	|Teste Yaman				|
		|CPF					|<CPF>						|
		|E-mail					|testeyaman@teste.com.uk	|
		|Confirmação de e-mail	|testeyaman@teste.com.uk	|
		|Criar Senha			|Teste@123					|
		|Repetir senha			|Teste@123					|
		E finalizo a segunda etapa
		|Número do cartão		|<Número do Cartão>			|
		|Mês					|<Mês>		  				|
		|Ano					|<Ano>						|
		|Celular				|<Celular>				  	|
		Entao exibe a mensagem de erro "<Mensagem>" no cadastro de cartao
		
		Exemplos:
		|CPF				|Número do Cartão		|Mês		|Ano	|Celular		|Mensagem														|Informações		|
    	|970.137.710-90		|0000 0000 0000 0000	|Janeiro	|2021	|1899122-2941	|Ops! Algo deu errado. Por favor, tente novamente.				|número de cartão  	|
    	|443.329.610-48		|6550 0000 0000 0009	|Janeiro	|2021	|18				|Não está informando o erro no celular - verificar a mensagem.	|número de celular  |
    
  @beatriz @cadastro
	Esquema do Cenário: Cadastro com <Informações> em branco na etapa de cadastro de cartão
		Quando preencho os dados da primeira etapa
		|Nome Completo		  	|Teste Yaman				|
		|CPF					|<CPF>						|
		|E-mail					|testeyaman@teste.com.uk	|
		|Confirmação de e-mail	|testeyaman@teste.com.uk	|
		|Criar Senha			|Teste@123					|
		|Repetir senha			|Teste@123					|
		E finalizo a segunda etapa
		|Número do cartão		|<Número do Cartão>			|
		|Mês					|<Mês>		  				|
		|Ano					|<Ano>						|
		|Celular				|<Celular>				  	|
		Entao exibe a mensagem de erro "<Mensagem>" no campo
		
		Exemplos:
		|CPF				|Número do Cartão		|Mês		|Ano	|Celular		|Mensagem							|Informações	  	|
    	|700.543.990-25		|						|Janeiro	|2021	|1899122-2941	|Confira o campo Número do Cartão	|número do cartão 	|
    	|210.482.670-59		|6550 0000 0000 0009	|Mês		|2021	|1899122-2941	|Confira o campo Vencimento			|mês 			  	|
    	|533.757.190-78		|6550 0000 0000 0009	|Janeiro	|Ano	|1899122-2941	|Confira o campo Vencimento			|ano				|
    
  @beatriz @cadastro
	Esquema do Cenário: Cadastro com data de vencimento do cartão inválida
		Quando preencho os dados da primeira etapa
		|Nome Completo		  	|Teste Yaman				|
		|CPF					|<CPF>						|
		|E-mail					|testeyaman@teste.com.uk	|
		|Confirmação de e-mail	|testeyaman@teste.com.uk	|
		|Criar Senha			|Teste@123					|
		|Repetir senha			|Teste@123					|
		E finalizo a segunda etapa
		|Número do cartão		|<Número do Cartão>			|
		|Mês					|<Mês>		  				|
		|Ano					|<Ano>						|
		|Celular				|<Celular>				  	|
		Entao exibe a mensagem de erro "<Mensagem>"
		
		Exemplos:
		|CPF				|Número do Cartão		|Mês		|Ano	|Celular		|Mensagem																					|
    	|876.901.280-68		|6550 0000 0000 0009	|Janeiro	|2019	|18998228978	|Ops! O vencimento do cartão está incorreto. Verifique se preencheu corretamente este campo	|
    
