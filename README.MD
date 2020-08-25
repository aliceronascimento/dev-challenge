Sistema de análise de dados de venda que irá importar lotes de arquivos
e produzir relatórios baseado em informações presentes nos arquivos.
Existem 3 tipos de dados dentro dos arquivos e eles podem ser distinguidos
pelo seu identificador que estará presente na primeira coluna de cada linha,
onde o separador de colunas é o caractere “ç”.

* Identificador do Vendedor: 001
	exemplo: 001ç1234567891234çPedroç50000
* Identificador do cliente: 002
	exemplo: 002ç2345675434544345çJosedaSilvaçRural
* Identidicador da venda: 003
	exemplo: 003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo

* Conteúdo do arquivo deve estar obrigatoriamente na seguinte distribuição: 
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
002ç2345675434544345çJosedaSilvaçRural
002ç2345675433444345çEduardoPereiraçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo

* O sistema lê continuamente todos os arquivos dentro do diretório -> /home/data/in/

- Os arquivos de entrada devem estar no diretório: /home/data/in/
- Os arquivos de saída devem estar no diretório: /home/data/out/

