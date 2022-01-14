package io.vepo.advanced.sintax;

import org.junit.jupiter.api.Test;

import io.vepo.advanced.sintax.SintaxAdvanced.Par;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Sintax")
class SintaxAdvancedTest {

    @Test
    @DisplayName("PASSO 1 - Usando Varargs")
    void usandoVarargsTest() {
        var obj = new SintaxAdvanced();
        /**
         * TODO: [PASSO-1] Usando Varargs
         * 
         * Para fazer funcionar, implemente os métodos varArgsManyStrings e 
         * varArgsManyIntegers na class SintaxAdvanced. 
         * 
         * Varargs é um meio de se conseguir adicionar um número variável de 
         * argumentos a um método. Para se conseguir isso em Java, devemos 
         * adicionar "..." ao último parâmetros do método, assim pode 
         * ser chamado com nenhum valor, com apenas um ou com vários. Uma 
         * limitação do varargs é que todos os parâmetros devem ter o mesmo tipo.
         * Essa não é uma limitação do Java, isso já acontece em outras linguagens
         * como C. Outra preucação é não usar com Generics (ver [PASSO-2]) pois isso
         * causará uma situação chamada Heap Pollution.
         * 
         * Por exemplo, o método abaixo:
         * 
         * public class ClassName {
         *     public List<String> methodName(String... params) {
         *         // código
         *     }
         * }
         * 
         * Pode ser usado como:
         * obj.methodName()
         * obj.methodName("arg1")
         * obj.methodName("arg2")
         * obj.methodName("arg3")
         * 
         * Apesar de params ser definido como uma String, esse tipo só é valido para quem está chamando esse 
         * método. Internamente ele será uma String[].
         * 
         * Implemente as funções varArgsManyStrings e varArgsManyIntegers.
         */
        Assertions.assertEquals(obj.varArgsManyStrings("PARAM1"), Collections.singletonList("PARAM1"));
        Assertions.assertEquals(obj.varArgsManyStrings("PARAM1", "PARAM2", "PARAM3", "PARAM4", "PARAM5", "PARAM6", "PARAM7"),
                                Arrays.asList("PARAM1", "PARAM2", "PARAM3", "PARAM4", "PARAM5", "PARAM6", "PARAM7"));

        Assertions.assertEquals(obj.varArgsManyIntegers(1), Collections.singletonList(1));
        Assertions.assertEquals(obj.varArgsManyIntegers(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 
                                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    public static class MyPojo {
        private String value;

        public MyPojo(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static record MyRecord (String value) {}

    @Test
    @DisplayName("PASSO 2 - Usando Generics")
    void ussandoGenericsTest() {
        var obj = new SintaxAdvanced();
        /**
         * TODO: [PASSO-2] Usando Generics
         * 
         * Generics é outro modo de criar métodos poderosos. Essa funcionalidade
         * deve ser usada sempre que um mesmo código puder ser usado para várias
         * classes que não possuem nenhuma interface/herança em comum (além do Object).
         * 
         * Com ela é possível definir um ou mais tipos que serão resolvidos em tempo
         * de compilação. Generics podem ser usado em classes e métodos. Vamos olhar
         * como isso funciona? Vamos definir uma classe que aceita um tipo generico T.
         * 
         * public class GenericWrapper<T> {
         *     private T obj;
         *     public GenericWrapper(T obj) {
         *         this.obj = obj;
         *     }
         * 
         *     public T getObj() { return this.obj; }
         * }
         * 
         * Observe que estamos definindo o tipo T na definição da classe e podemos usar ele
         * em qualquer lugar da classe. T não é uma classe, é uma definição que só existe 
         * dentro da classe GenericWrapper e referencia uma classe existente. 
         * 
         * Para definirmos um tipo generico em uma função podemos usar essa mesma definição 
         * na assinatura da função. Veja o exemplo abaixo.
         * 
         * public <T extends Number, J extends Number> int somaComoInteiro(T a, J b) {
         *     return a.intValue() + b.intValue();
         * }
         * 
         * Esse exemplo não é dos melhores porque poderiamos só usar o tipo Number. Mas
         * com ele consigo demonstrar mais duas funcionalidades do Generics. Podemos ter
         * mais de um tipo generico definido e podemos limitar o escopo do generico a uma
         * classe ou interface.
         * 
         * No teste abaixo você será desafiado a criar um método e alterar uma classe já criada 
         * para que todos os testes passem com um tipo genérico.
         */
        Par<MyPojo, MyRecord> par = obj.par(new MyPojo("value1"), new MyRecord("value2"));
        Assertions.assertEquals(par.getPrimeira().getValue(), "value1");
        Assertions.assertEquals(par.getSegunda().value(), "value2");
    }
}