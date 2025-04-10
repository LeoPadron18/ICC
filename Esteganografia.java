public class Esteganografia {
    
    /**
     * Toma la n-ésima letra de cada palabra para obtener el mensaje oculto.
     * @param original El mensaje original.
     * @param n El índice que se tiene que tomar de cada palabra (comenzando en 0).
     * @return El mensaje oculto, sin espacios.
     */
    public String descifraNulo(String original, int n) {
        String resultado = "";
        String palabraActual = "";
        
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (esDelimitador(c)) {
                if (!palabraActual.isEmpty()) {
                    if (n < palabraActual.length()) {
                        resultado += palabraActual.charAt(n);
                    }
                    palabraActual = "";
                }
            } else {
                palabraActual += c;
            }
        }
        
        // Procesar la última palabra
        if (!palabraActual.isEmpty() && n < palabraActual.length()) {
            resultado += palabraActual.charAt(n);
        }
        
        return resultado;
    }
    
    /**
     * Versión que obtiene n de los espacios al final
     */
    public String descifraNulo(String original) {
        int n = contarEspaciosFinal(original);
        return descifraNulo(original.trim(), n);
    }
    
    /**
     * Busca un nombre oculto en un texto
     */
    public boolean contieneNombre(String mensaje, String nombre) {
        String mensajeNormalizado = normalizarTexto(mensaje);
        String nombreNormalizado = normalizarTexto(nombre);
        return mensajeNormalizado.contains(nombreNormalizado);
    }
    
    /**
     * Reconstruye el mensaje oculto a partir de palabras diferentes
     */
    public String descifraPalabrasMarcadas(String m, String e) {
        String resultado = "";
        String palabraM = "";
        String palabraE = "";
        int posM = 0;
        int posE = 0;
        
        while (posM < m.length() || posE < e.length()) {
            palabraM = obtenerSiguientePalabra(m, posM);
            palabraE = obtenerSiguientePalabra(e, posE);
            
            posM += palabraM.isEmpty() ? 1 : palabraM.length();
            posE += palabraE.isEmpty() ? 1 : palabraE.length();
            
            // Avanzar sobre delimitadores
            while (posM < m.length() && esDelimitador(m.charAt(posM))) posM++;
            while (posE < e.length() && esDelimitador(e.charAt(posE))) posE++;
            
            if (!palabraM.isEmpty() && !palabraE.isEmpty() && !palabraM.equals(palabraE)) {
                if (!resultado.isEmpty()) resultado += " ";
                resultado += palabraM;
            }
        }
        
        return resultado;
    }
    
    /**
     * Reconstruye el mensaje oculto a partir de letras diferentes
     */
    public String descifraLetrasMarcadas(String m, String e) {
        String resultado = "";
        int posM = 0;
        int posE = 0;
        
        while (posM < m.length() && posE < e.length()) {
            char cM = m.charAt(posM);
            char cE = e.charAt(posE);
            
            if (!esDelimitador(cM) && !esDelimitador(cE)) {
                if (cM != cE) resultado += cM;
                posM++;
                posE++;
            } else {
                if (esDelimitador(cM)) posM++;
                if (esDelimitador(cE)) posE++;
            }
        }
        
        return resultado;
    }
    
    // Métodos auxiliares
    private boolean esDelimitador(char c) {
        return c == ' ' || c == '\t' || c == '\n';
    }
    
    private int contarEspaciosFinal(String texto) {
        int n = 0;
        int i = texto.length() - 1;
        while (i >= 0 && texto.charAt(i) == ' ') {
            n++;
            i--;
        }
        return n;
    }
    
    private String normalizarTexto(String texto) {
        String normalizado = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) {
                normalizado += Character.toLowerCase(c);
            }
        }
        return normalizado;
    }
    
    private String obtenerSiguientePalabra(String texto, int posInicial) {
        String palabra = "";
        int pos = posInicial;
        while (pos < texto.length() && !esDelimitador(texto.charAt(pos))) {
            palabra += texto.charAt(pos);
            pos++;
        }
        return palabra;
    }
}