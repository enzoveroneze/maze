# Gerador de labirintos aleatórios

## Uso
Com o gerenciador de projetos _Leiningen_ instalado, execute
```sh
$ lein run <Largura> <Comprimento>
```
com as respectivas largura e comprimento desejados para o labirinto.

## Funcionamento
O programa primeiro gera um grafo, que representa um labirinto 'completo', com todas as paredes,\
e aleatoriza a ordem das arestas. É aplicado nesse grafo um algoritmo de *árvore geradora mínima*,
que remove arestas, deixando um grafo conectado mas sem ciclos. O grafo resultante é impresso\
em forma de labirinto utilizando caracteres *Unicode*.

## Processo de desenvolvimento
Em retrospecto, a escolha do algoritmo talvez não tenha sido a melhor para um projeto em linguagem funcional\
já que a implementação requer etapas bastante imperativas, não funcionando bem sem mutabilidade. Tanto é,\
que descobri não ser possível implementar este (e alguns outros) algoritmos de maneira puramente funcional\
com eficiência equivalente à uma implementação imperativa tradicional, o que foi uma surpresa para mim, pois sempre\
imaginei que os dois paradigmas fossem equivalentes.

Usei uma linguagem nova para mim, Clojure, que foi bastante interessante. Ela traz alguns conceitos novos, por\
ser da família Lisp, e aparenta ser mais 'prática' para desenvolvimento do que o Haskell.

## Screencast
[Link](https://drive.google.com/file/d/1-M2n4I_HVG20QaswaeGPPv8_GKyKgfsQ/view?usp=sharing)

## Referências
* https://cp-algorithms.com/graph/mst_kruskal.html
* http://dnaeon.github.io/graphs-and-clojure/
* https://weblog.jamisbuck.org/2011/2/7/maze-generation-algorithm-recap.html
