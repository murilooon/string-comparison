# string-comparison

# Comparação entre Algoritmos de Busca em Strings Utilizando Java	
 	 	
Eduardo de Paula Pazini1, Êrica Peters2, Murilo Oliveira Nascimento³
1Departamento de Ciência da Computação
Universidade do Estado de Santa Catarina (UDESC) – Joinville, SC – Brasil

eduardopazzzini@gmail.com, ericapeterssc@gmail.com,  murilo.on@hotmail.com


Resumo. Este texto descreve diferentes tipos de algoritmos de busca de palavras em um texto qualquer, suas vantagens e desvantagens, a comparação entre eles e cada tempo médio de processamento. É um texto para a matéria de Projeto de Arquivos - ministrada pelo professor Glauco Vinicius Scheffel - sendo este considerado uma atividade avaliativa.  

## 1. Introdução

A ideia principal deste projeto é o desenvolvimento de 6 algoritmos diferentes de busca em texto, entre eles: Naive, Rabin Karp, Knuth-Morris-Prat (KMP), Boyer-Moore, Aho-Corasick, Radix tree. Este trabalho acadêmico foi dividido em várias etapas de produção para assim facilitar seu desenvolvimento e manutenção, sendo todo ele confeccionado na linguagem Java¹.

Primeiramente desenvolveu-se a interface gráfica utilizando a ferramenta Swing², partindo em seguida para a implementação dos algoritmos de busca e finalizando com testes para validação do funcionamento dos algoritmos. Além disso, o resultado das buscas é salvo em um arquivo .csv. Todo o código pode ser encontrado no GitHub (https://github.com/murilooon/strings).

#2. Interface Gráfica

Tudo começa na interface gráfica, onde tem-se a primeira tela gráfica logo após a execução do projeto, como mostrado na Figura 1. Nela tem-se primeiramente os arquivos no qual as palavras podem ser buscadas, sendo esses em formato .txt. No projeto optou-se por fazer o download de arquivos texto de livros do escritor Shakespeare³.

Figura 1. Tela inicial

A seguir tem-se um botão para incluir o arquivo escolhido na lista de arquivos que serão utilizados para a procura da palavra digitada no campo disponível no centro da tela gráfica. Após isso, pode-se selecionar a opção “Procurar palavra”, no qual o programa irá iniciar a busca da palavra escolhida nos arquivos selecionados. Caso a palavra não seja encontrada, um aviso seja mostrado na tela alertando o usuário. Caso contrário, esta tela será fechada e outra aparecerá.

Na segunda e última tela, mostrada na Figura 2, mostra-se o resultado da busca em cada um dos algoritmos, no formato de uma tabela. No qual a primeira coluna apresenta o arquivo utilizado, a segunda o método/algoritmo, na terceira em qual linha a palavra foi encontrada, na quarta em qual coluna estava e finalizando com a última coluna mostrando o tempo de processamento, em milissegundos, para encontrar a string desejada.

Figura 2. Tela resultados

Enfim, depois de todo o processo tem-se ainda a disponibilidade de fazer uma nova busca pressionando o campo “Nova Busca” ou encerrar o programa no botão “Sair”.

## 3. Naive

O algoritmo Naive é comumente chamado de algoritmo de força bruta. Ele consiste em comparar a palavra que se quer procurar com todas as outras palavras existentes, de maneira linear, fazendo uma comparação inocente. Portanto, para cadeias pequenas essa técnica é aceitável, entretanto, quanto mais cresce o universo de busca, mais demorado fica, podendo ser comparado com um crescimento exponencial de tempo.

Sendo assim, o algoritmo Naive tende a ser ruim (lento), porém com uma implementação simples e trivial.

## 4. Rabin

O algoritmo Rabin, inventado por M. Rabin e R. Karp, também é conhecido como busca por impressão digital (fingerprint search). Ele compara padrão com texto indiretamente:  procurando um segmento do texto que tenha o mesmo valor hash do padrão.

Pode ser considerado uma evolução do modelo Força Bruta. Ao invés de comparar a janela com o padrão caracter a caracter, é proposto usar uma comparação numérica entre os restos da divisão por um mesmo inteiro da janela e do padrão.

Em aplicações envolvendo longas cadeias de caracteres, pode-se representar tais objetos por valores numéricos por uma função de espalhamento, por exemplo. O importante é que dois objetos distintos tenham pouca chance de terem a mesma impressão digital, de maneira que, para decidir se dois objetos são iguais, possamos comparar não eles diretamente, mas seus valores numéricos atribuídos.
Como conclusão, o algoritmo de Rabin tenta diminuir o número de comparações através do cálculo de um hash da palavra procurada e da substring, porém através deste procedimento ele se torna puramente probabilístico. Porém, na prática, o algoritmo tem bom desempenho. 

Pode ser válido para qualquer alfabeto, bastando apenas interpretar cada caractere como um dígito.

## 5. Knuth-Morris-Prat (KMP)

O algoritmo de Knuth-Morris-Prat foi inventado por Donald Knuth e Vaughan Pratt e independentemente por James Morris em 1977, embora os três tenham-no publicado conjuntamente. A ideia deste algoritmo é que ele procura a ocorrência de uma palavra dentro de um texto empregando a simples técnica de que quando aparece uma diferença, a palavra tem em si a informação necessária para determinar onde começar a próxima comparação.

O algoritmo KMP é linear, logo ele faz apenas M comparações entre caracteres para construir o DFA e depois no máximo N comparações entre caracteres para procurar o padrão. Examinando assim não mais que M + N caracteres. Levando em conta o tempo.
Enfim, o algoritmo de Knuth-Morris-Prat é rápido e tem a vantagem de nunca retroceder sobre o texto, o que é importante se o texto for dado como um fluxo contínuo (streaming).

## 6. Boyer-Moore

O algoritmo de busca de expressões Boyer-Moore é um eficiente algoritmo de busca que é o padrão de qualidade para busca prática de expressões em literatura. Foi desenvolvido por Robert S. Boyer e J Strother Moore em 1977. O algoritmo pré-processa a string sendo procurada (o padrão), mas não a string em que é feito a busca (o texto). É muito bem aproveitado, com bom desempenho, para aplicações em que o padrão é muito menor do que o texto ou onde persiste por múltiplas buscas. 

As características chaves do algoritmo são combinar na cauda do padrão ao invés da cabeça, e pular pelo texto em deslocamentos de múltiplos caracteres ao invés de procurar cada caractere no texto. Em geral, o algoritmo roda mais rápido de acordo com o tamanho do padrão aumenta.

## 7. Comparação
Várias buscas de palavras foram feitas, resultando em comparações interessantes, uma delas está mostrada abaixo, na Figura 3.

Figura 3. Comparação

Foi feita a busca da palavra “amends” no arquivo “AMidsummerNightsDream” utilizando os 4 algoritmos implementados. Todos os buscadores encontraram a palavra, na mesma linha (3335) e coluna (14), porém com tempo de processamento diferente. O algoritmo de Boyer teve o melhor resultado, demorando apenas 4 milissegundos, seguido do KPM, processando em 12 milissegundos, em terceiro lugar o algoritmo Naive, finalizando em 22 milissegundos, e por último lugar o Rabin, com 118 milissegundos.

Percebeu-se que essa sequência na colocação dos algoritmos podia variar em alguns casos, entretanto, tendia a permanecer igual tendo uma visão total dos resultados.

## 8. Testes

Para cada algoritmo implementado, foi construído um teste para sua validação. Nestes testes foram passados palavras em arquivos que deveriam serem encontradas e o algoritmo foi rodado para verificar se ele também achava.
Testes são uma parte bem importante em um projeto de desenvolvimento de software, pois ele valida o funcionamento correto de implementações novas no código fonte sem “quebrar” partes já implementadas anteriormente.

No total foram criados 4 arquivos com 2 testes em cada, total de 8 testes, logo, 2 por algoritmo, e todos passaram corretamente, validando assim os algoritmos de busca.

## Referências

Oracle (2017) “Creating a GUI With JFC/Swing”, https://docs.oracle.com/javase/tutorial/uiswing/index.html, November.²

P, Paulan (1999) “Essentials of the Java Programming Language, Part 1”, https://www.oracle.com/technetwork/java/index-138747.html, November.¹

Wikipédia (2018) “William Shakespeare”, https://pt.wikipedia.org/wiki/William_Shakespeare, November.³
