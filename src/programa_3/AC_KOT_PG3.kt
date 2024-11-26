package programa_3

fun main () {
    print("?: ")
    val expresion: String = readln();
    val resultado = comprobarSintaxis(expresion);

    print("¿Esta balanceado? = $resultado")
}

fun comprobarSintaxis(expresion: String): Boolean {
    val delimitadoresAbiertos: MutableList<Char> = mutableListOf();

    for (i in expresion) {
        when(i) {
            '[', '(', '{' -> {
                delimitadoresAbiertos.add(i);
            }

            ']', ')', '}' -> {
                // Cuando se encuentre un delimitador cerrado en la posicion actual lo comparara con el ultimo delimitador abierto (ultimo de la lista de delimitadoresAbiertos)
                // Si la lista esta vacia y se intenta comparar significara que hay mas delimitadores cerrados que abiertos
                if (delimitadoresAbiertos.none() || !comprobarAbiertoConCerrado(delimitadoresAbiertos.last(), i)) {
                    return false;
                }

                // Una vez la comprobacion fue exitosa (comprobarAbiertoConCerrado() = true) significara
                // que el ultimo delimitador abierto encontrado con el primer delimitador cerrado encontrado son del mismo "tipo"
                delimitadoresAbiertos.removeAt(delimitadoresAbiertos.size - 1);
            }
        }
    }

    // Si la lista esta vacia (Ningun delimitador abierto sin comparar ha quedado pendiente) retornara true
    return delimitadoresAbiertos.none();
}

/**
 * Abierto -> Ultimo delimitador abierto encontrado
 * Cerrado -> Cada delimitador cerrado
 *
 * Si son del mismo "tipo" retornara true
 */
fun comprobarAbiertoConCerrado(abierto: Char, cerrado: Char): Boolean {
    if ((abierto == '[' && cerrado == ']') || (abierto == '(' && cerrado == ')') || (abierto == '{' && cerrado == '}')) {
        return true;
    }
    return false;
}