# language: pt
# Author: Fernando Toledo Moreira


Funcionalidade: Login no site Elo
	Eu como usuário cadastrado no site Elo
	Desejo acessar minha conta 
	Para consultar e aproveitar as vantagens exclusivas do cliente
	
	
  @ParticiparPomocaoVemVidao
	Esquema do Cenário: validar a incrição na promoção - Campanha Vem Vidão
		Quando realizo login com os dados "<CPF>" e "<Senha>"
		Entao seleciono a promocao vem vidao
		
    Exemplos:
    |CPF            |Senha     |  
    |407.092.860-07 |Teste@123 | 
     
   
    
    
    