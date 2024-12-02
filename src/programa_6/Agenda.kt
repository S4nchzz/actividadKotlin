package programa_6

class Agenda {
    val contactos: MutableList<Contacto> = mutableListOf();
    val nMaxContactos: Int;

    constructor(nMaxContacts: Int) {
        this.nMaxContactos = nMaxContacts;
        showMenu()
    }
    constructor() : this(10) {
        showMenu();
    }

    private fun showMenu() {
        var choice:Int = -1
        do {
            if (choice !in 1..7 && choice != -1) {
                println("Opcion invalida\n")
            }

            println("\n1. Añadir contacto")
            println("2. Listar Contactos")
            println("3. Buscar contacto")
            println("4. Existe contacto")
            println("5. Eliminar contacto")
            println("6. Contactos disponibles")
            println("7. Agenda llena")
            println("8. Salir")
            print("?:")

            choice = readln().toInt();

            selectOption(choice);
        } while (choice != 8);
    }

    private fun selectOption(choice: Int) {
        when(choice) {
            1 -> {
                if (contactos.size >= nMaxContactos) {
                    println("Ya existen ${contactos.size}/$nMaxContactos contactos")
                    return;
                }

                println("----- Añadir contacto -----")

                print("Nombre del contacto: ")
                val nombre: String = readln();

                if (contactos.find { it.nombre.equals(nombre, true) } != null) {
                    println("No se ha añadido el contacto $nombre ya que el nombre usado ya pertenece a otro contacto")
                    return;
                }

                print("Telefono del contacto: ")
                val telf: String = readln();

                contactos.add(Contacto(nombre, telf));
                println("Se ha añadido el contacto $nombre correctamente")
            }

            2 -> {
                println("----- Listado de contactos -----")
                for (contacto in contactos) {
                    println(contacto)
                }
            }

            3 -> {
                println("----- Busqueda de contacto -----")
                print("Nombre a buscar: ")
                val nombreBusqueda = readln();

                val contacto: Contacto? = contactos.find { it.nombre.equals(nombreBusqueda, true) };

                contacto.let {
                    if (contacto != null) {
                        println("Telf: ${contacto.telf}")
                        return;
                    }
                }

                println("El nombre $nombreBusqueda no se ha encontrado")
            }

            4 -> {
                println("----- Existe X Contacto? -----")
                print("Nombre del contacto: ")
                val nombre: String = readln();

                val contacto: Contacto? = contactos.find { it.nombre.equals(nombre, true) }

                contacto?.let {
                    println("Contacto $nombre existe")
                    return;
                }

                println("Contacto $nombre no existe")
            }

            5 -> {
                println("----- Eliminar contacto -----")
                val nombre: String = readln();

                if (contactos.removeIf { it.nombre.equals(nombre, true) }) {
                    println("Se ha eliminado el contacto $nombre")
                    return;
                }

                println("No se ha eliminado el contacto $nombre")
            }

            6 -> {
                println("----- Huecos Libres -----")
                println("Hay ${nMaxContactos - contactos.size} contacto/s libre/s")
            }

            7 -> {
                println("----- Agenda llena -----")
                if (contactos.size >= nMaxContactos) {
                    println("La agenda esta llena")
                    return;
                }

                println("La agenda no esta llena")
            }
        }
    }
}