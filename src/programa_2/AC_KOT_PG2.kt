package programa_2

fun main () {
    print("Introduzca una palabra: ")
    val firstWord: String = readln();
    print("Segunda palabra: ")
    val secondWord: String = readln();

    val result = compareWords(firstWord, secondWord);
    print("¿Las palabras $firstWord y $secondWord son un anagrama? = $result")
}

fun compareWords(firstWord: String, secondWord: String): Boolean {
    if (firstWord == secondWord) {
        return false;
    }

    if (firstWord.length != secondWord.length) {
        return false;
    }

    // Palabra que se lee de izquierda a derecha
    // return firstWord.reversed() == secondWord;

    // Palabra que tiene las mismas letras que la segunda en distinto orden

    // Metodo count que sirve para contar el numero de caracteres iguales al proporcionado https://www.baeldung.com/kotlin/string-character-count-occurrences
    for (i in 0..firstWord.length - 1) {
        if (secondWord.count{ it == firstWord[i] } != firstWord.count { it == firstWord[i] }) {
            return false;
        }
    }

    return true;
}