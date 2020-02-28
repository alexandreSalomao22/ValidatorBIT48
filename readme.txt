Classe principal para rodar o projeto -> Principal.java

A função do programa é quebrar e verificar o bit48 da ISO.

Exemplo:
Tamanho variavel 
XX - Qual o BIT
TM - Tamanho do BIT
YY - Conteudo do BIT

** Lembrando que o tamanho do BIT TM , tem que ser multiplicado por 2 **
Ex: TM = 12, YY = 24
XX 00TM YYYYYYYYYYYYYYYYYYYYYYYY

Em caso de tamanho fixo não contem o tamanho, é diretamente o BIT + CAMPO
Ex:
XX - BIT
YY - CAMPO

XXYYYYYYYYYY

A documentação do mapeamento dos bits esta sobre propriedade da REDE.

********************EXECUÇÃO*************************************

Passar o caminho onde está os arquivos em txt. ( NA JOPTIONPANE que irá abrir Ex: C:\log_salvo)
Passar o nome do arquivo que você deseja salvar.
Passar o que está procurando em cada linha, por padrão pesquisar o valor 54, pois todas as ISO's se iniciam com o valor 54.
Apos a execução do programa ira ser criado a pasta: C:\log_salvo, e o log com o nome desejado estara criado.
