# language: pt

Funcionalidade: Recuperação de senha de cadastro no site Elo
	Eu como usuário cadastrado no site Elo
	Desejo recuperar minha senha
	Para voltar a ter acesso às promoções e vantagens exclusivas do cliente
	
	
	@beatriz @resgateSenha
	Esquema do Cenário: Solicitação de resgate de senha via e-mail
		Dado que estou na tela de resgate de senha
		Quando informo o CPF "<CPF>" para recuperar a senha via e-mail
		Entao exibe a mensagem "O código de redefinição foi enviado para o seu email"

		Exemplos:
    	|CPF            |
    	|760.165.350-10 |
  
  @beatriz @resgateSenha
	Esquema do Cenário: Solicitação de resgate de senha via sms
		Dado que estou na tela de resgate de senha
		Quando informo o CPF "<CPF>" para  recuperar a senha via sms
		Entao exibe a mensagem "O código de redefinição foi enviado para o seu telefone"
		
		Exemplos:
    	|CPF            |
    	|392.962.070-70 |
  
  #Outros cenários
	Cenário: Redefinir senha com sucesso
  	Cenário: Redefinir senha com dados inválidos
  	Cenário: Redefinir senha com dados em branco
