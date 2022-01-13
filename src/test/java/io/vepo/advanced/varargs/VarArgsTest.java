package io.vepo.advanced.varargs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Varargs")
class VarArgsTest {

    @Test
    @DisplayName("S01T01 - Usando Varargs")
    void usingVarargsTest() {
        var obj = new VarArgs();
        /**
         * [PASSO-1] 
         * 
         * Para fazer funcionar, implemente o método many na class VarArgs. 
         * VarArgs é um meio de se conseguir adicionar um ou mais argumentos a um
         * método. Para se conseguir isso em Java, devemos adicionar ... ao último 
         * parametros de um método, assim pode ser chamado com nenhum valor, com 
         * apenas um ou com vários. Por exemplo, o método abaixo:
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
         * Implemente as funções manyStrings e manyIntegers.
         */
        Assertions.assertEquals(obj.simple("PARAM1"), Collections.singletonList("PARAM1"));

        Assertions.assertEquals(obj.manyStrings("PARAM1"), Collections.singletonList("PARAM1"));
        Assertions.assertEquals(obj.manyStrings("PARAM1", "PARAM2", "PARAM3", "PARAM4", "PARAM5", "PARAM6", "PARAM7"), 
                                Arrays.asList("PARAM1", "PARAM2", "PARAM3", "PARAM4", "PARAM5", "PARAM6", "PARAM7"));

        Assertions.assertEquals(obj.manyIntegers(1), Collections.singletonList(1));
        Assertions.assertEquals(obj.manyIntegers(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 
                                                 Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}