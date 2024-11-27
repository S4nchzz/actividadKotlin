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
    var winner: String? = null;

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
        return null;
    }

    val column_1: List<String> = listOf(matrix[0][0], matrix[1][0], matrix[2][0])
    val column_2: List<String> = listOf(matrix[0][1], matrix[1][1], matrix[2][1])
    val column_3: List<String> = listOf(matrix[0][2], matrix[1][2], matrix[2][2])

    val diagonalLeft: List<String> = listOf(matrix[0][0], matrix[1][1], matrix[2][2])
    val diagonalRight: List<String> = listOf(matrix[0][2], matrix[1][1], matrix[2][0])

    if (column_1.count { it == "X" } == 3 || column_1.count { it == "O" } == 3) {
        winner = column_1[0];
    }

    if (column_2.count { it == "X" } == 3 || column_2.count { it == "O" } == 3) {
        winner?.let {
            if (winner != column_2[0]) {
                print("Hay un error en la matriz y han ganado los 2 jugadores ")
                return null;
            }
        } ?: run {
            winner = column_2[0];
        }
    }

    if (column_3.count { it == "X" } == 3 || column_3.count { it == "O" } == 3) {
        winner?.let {
            if (winner != column_3[0]) {
                print("Hay un error en la matriz y han ganado los 2 jugadores ")
                return null;
            }
        } ?: run {
            winner = column_3[0];
        }
    }

    if (diagonalLeft.count { it == "X" } == 3 || diagonalLeft.count { it == "O" } == 3) {
        winner?.let {
            if (winner != diagonalLeft[0]) {
                print("Hay un error en la matriz y han ganado los 2 jugadores ")
                return null;
            }
        } ?: run {
            winner = diagonalLeft[0];
        }
    }

    if (diagonalRight.count { it == "X" } == 3 || diagonalRight.count { it == "O" } == 3) {
        winner?.let {
            if (winner != diagonalRight[0]) {
                print("Hay un error en la matriz y han ganado los 2 jugadores ")
                return null;
            }
        } ?: run {
            winner = diagonalRight[0];
        }
    }

    for (row in matrix) {
        if (row.count { it == "X" } == 3 || row.count{ it == "O" } == 3) {
            winner?.let {
                if (winner != row[0]) {
                    print("Hay un error en la matriz y han ganado los 2 jugadores ")
                    return null;
                }
            } ?: run {
                winner = row[0];
            }
        }
    }

    winner?.let {
        return winner;
    }

    return "EMPATE";
}
