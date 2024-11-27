package programa_5

fun main () {
    val matrix: MutableList<MutableList<String>> = mutableListOf();

    val firstRow: MutableList<String> = mutableListOf("X", "O", "X");
    val secondRow: MutableList<String> = mutableListOf("X", "X", "O");
    val thirdRow: MutableList<String> = mutableListOf("X", "X", "X");
    matrix.add(firstRow);
    matrix.add(secondRow);
    matrix.add(thirdRow);

    print(analizeMatrix(matrix))
}

fun analizeMatrix(matrix: MutableList<MutableList<String>>): String? {
    if (estaDesproporcionado(matrix)) {
        return null;
    }

    val column_1: List<String> = listOf(matrix[0][0], matrix[1][0], matrix[2][0])
    val column_2: List<String> = listOf(matrix[0][1], matrix[1][1], matrix[2][1])
    val column_3: List<String> = listOf(matrix[0][2], matrix[1][2], matrix[2][2])

    val diagonalLeft: List<String> = listOf(matrix[0][0], matrix[1][1], matrix[2][2])
    val diagonalRight: List<String> = listOf(matrix[0][2], matrix[1][1], matrix[2][0])

    val colsAndDiagonals: MutableList<List<String>> = mutableListOf();
    colsAndDiagonals.add(column_1);
    colsAndDiagonals.add(column_2);
    colsAndDiagonals.add(column_3);
    colsAndDiagonals.add(diagonalRight);
    colsAndDiagonals.add(diagonalLeft);

    val winner: String = comprobarGanador(colsAndDiagonals) ?: return "EMPATE";

    return winner;
}

fun comprobarGanador(allPosibilities: List<List<String>>): String? {
    var winner: String? = null;
    for (posibility in allPosibilities) {
        if (posibility.count { it == "X" } == 3 || posibility.count{ it == "O" } == 3) {
            winner?.let {
                if (winner != posibility[0]) {
                    print("Hay un error en la matriz y han ganado los 2 jugadores ")
                    return null;
                }
            } ?: run {
                winner = posibility[0];
            }
        }
    }

    return winner;
}

fun estaDesproporcionado(matrix: MutableList<MutableList<String>>): Boolean {
    var xCount: Int = 0;
    var oCount: Int = 0;

    for (row in matrix) {
        for (symbol in row) {
            if (symbol == "X") {
                xCount++;
            } else if (symbol == "O") {
                oCount++;
            }
        }
    }

    if ((xCount > oCount && oCount + 1 != xCount) || (xCount < oCount && xCount + 1 != oCount)) {
        println("Los elementos estan desproporcionados")
        return true;
    }

    return false;
}
