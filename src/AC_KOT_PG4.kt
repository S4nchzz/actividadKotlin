fun main () {
    val atleta: MutableList<String> = mutableListOf("saltar", "saltar", "saltar", "saltar", "saltar");
    val pista: String = "||_||"

    print(correr(atleta, pista));
}

fun correr(atleta: MutableList<String>, pista: String): String {
    var pistaActualizada: String = "";

    var longestValue: Int = pista.length;
    var shortestValue: Int = atleta.size;

    if (atleta.size > pista.length) {
        longestValue = atleta.size;
        shortestValue = pista.length;
    }

    for (i in 0..<longestValue) {
        if (i > shortestValue - 1) {
            pistaActualizada += "?"
        } else {
            when(pista[i]) {
                '_' -> {
                    if (atleta[i] == "saltar") {
                        pistaActualizada += "x";
                    } else {
                        pistaActualizada += pista[i];
                    }
                }

                '|' -> {
                    if (atleta[i] == "correr") {
                        pistaActualizada += "/"
                    } else {
                        pistaActualizada += pista[i]
                    }
                }
            }
        }
    }
    return pistaActualizada;
}
