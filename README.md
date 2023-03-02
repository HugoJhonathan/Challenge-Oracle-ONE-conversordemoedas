## Challenge ONE Back End - Java
### Sprint 01: Crie seu próprio conversor de moeda

## História

Nesta oportunidade foi solicitado para nós Devs a criação de um conversor de moeda utilizando a linguagem Java. As características solicitadas por nosso cliente são as seguintes:

O conversor de moeda deverá:
- Converter de Reais a Dólar
- Converter de Reais a Euro
- Converter de Reais a Libras Esterlinas
- Converter de Reais a Peso Argentino
- Converter de Reais a Peso Chileno

Lembrando que deve ser possível também converter de forma inversa.

Como desafio extra incentivamos vocês a deixar fluir sua criatividade, se posso converter moedas, será que posso tal vez adicionar a meu programa outro tipo de conversões como temperatura por exemplo?

## Resultado

<a href="">Download JAR<a>

<img src="https://i.imgur.com/J6cdkmj.png">

### Conversão
- As unidades de medida foram criadas com a estrutura de Enum com construtor, onde cada unidade possui um **símbolo**, um **fator multiplicador** (que é usado no método para fazer a conversão entre as unidades) e o seu **nome**.
- Uma unidade pode ser **convertida para outra** chamando seu próprio método convert, assim:
```java
double result = REAL.convert(1, DOLAR);
```
- Ou através do método **convert** da classe **Conversor**, que converte e retorna um objeto do tipo **Result**:

```java
Result result = Conversor.convert(1, REAL, DOLAR); 

// class Result:
// sourceUnit   = REAL
// targetUnit   = DOLAR
// sourceAmount = 1
// result       = 0.1919
// toString()   = "R$ 1,00 (real) = US$ 0,19 (dólar)"

```
! O fator multiplicador das moedas é o valor equivalente de 1 em relação ao Dolar, para facilitar a conversão entre elas.


### GUI
- [x] Conforme sugerido para este Challenge, foi utilizado o kit de componentes GUI do próprio Java, chamado **Swing**, onde podemos criar componentes e interfaces gráficas com o paradígma orientado a objetos.

- [x] Fácil expansão e adição de novas unidades de conversão
- Para adicionar novas unidades, basta criar uma classe/enum que implemente a interface <a href="https://github.com/HugoJhonathan/Challenge-Oracle-ONE-conversordemoedas/blob/main/src/main/java/units/Unit.java">Unit</a>.
- Para adicionar a tela referente a essa nova unidade de conversão basta:  

    1- Criar uma classe que estenda a classe abstrata <a href="https://github.com/HugoJhonathan/Challenge-Oracle-ONE-conversordemoedas/blob/main/src/main/java/GUI/screens/Screen.java">Screen</a>.
    
    2- Implementar e concretizar os métodos abstratos.
    
    3- Adicionar essa nova tela ao objeto na NavBar, conforme <a href="https://github.com/HugoJhonathan/Challenge-Oracle-ONE-conversordemoedas/blob/main/src/main/java/GUI/Window.java#L27">estes</a>.
- Para criar qualquer outra tela, basta criar um classe que estenda de JPanel e implemente a interface <a href="https://github.com/HugoJhonathan/Challenge-Oracle-ONE-conversordemoedas/blob/main/src/main/java/GUI/ScreenProperties.java">Screen_Properties</a> e adicioná-la à NavBar.
