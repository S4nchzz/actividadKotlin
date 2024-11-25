package programa_3

fun main () {
    print("?: ")
    val expresion: String = readln();
    val resultado = comprobarSintaxis(expresion);

    print("¿Esta balanceado? = $resultado")
}

fun comprobarSintaxis(expresion: String): Boolean {
    val corchetes: MutableList<Boolean> = mutableListOf();
    val parentesis: MutableList<Boolean> = mutableListOf();
    val llaves: MutableList<Boolean> = mutableListOf();

    for (i in 0..expresion.length - 1) {
        when(expresion[i]) {
            '[' -> {
                corchetes.add(true);
            }

            '(' -> {
                parentesis.add(true)
            }

            '{' -> {
                llaves.add(true)
            }

            ']' -> {
                corchetes.add(false)
            }

            ')' -> {
                parentesis.add(false)
            }

            '}' -> {
                llaves.add(false)
            }
        }

    }

    if (comprobarDelimitador(corchetes) && comprobarDelimitador(parentesis) && comprobarDelimitador(llaves)) {
        return true;
    }

    return false;
}

fun comprobarDelimitador(delimitador: MutableList<Boolean>): Boolean {
    // Si la lista que se da no tiene ningun valor querra decir que en la expresion no se encontro un delimitador de tipo | (, {, [ |
    if (delimitador.none()) {
        return true;
    }

   // Si la longitud de la lista es impar querra decir que no se ha encontrado un delimitador de cierre
   // Si el primer valor de la lista es false querra decir que se ha encontrado un delimitador cerrado que uno abierto
    if (delimitador.size % 2 != 0 || !delimitador[0]) {
        return false;
    }

    val nDelimitadoresAbiertos = delimitador.count { it }
    val nDelimitadoresCerrados = delimitador.count { !it }

    // Si el numero de delimitadores abiertos es distinto que el numero de delimitadores cerrados significara que hay algun delimitador erroneo
    if (nDelimitadoresAbiertos != nDelimitadoresCerrados) {
        return false;
    }

    var abierto: Boolean = false;
    for (i in 0..delimitador.size - 2) {
        if (delimitador[i]) {
            abierto = true;
        } else {
            abierto = false;
        }

        if (abierto && !delimitador[i] && delimitador[i + 1]) {
            return false;
        }
    }

    return true;
}