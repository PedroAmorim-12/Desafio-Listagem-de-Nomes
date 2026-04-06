import java.io.File

fun main() {
    val dataDir = File("data")
    if (!dataDir.exists()) dataDir.mkdir()
    val nomes = File("data/nomes.txt")
    val sobrenomes = File("data/sobrenomes.txt")

    if (!nomes.exists()) nomes.createNewFile()
    if (!sobrenomes.exists()) sobrenomes.createNewFile()

    var valor = true

    while (valor) {
        val acao = menu()

        when (acao) {
            1 -> {
                val name = inserir("Nome")
                val listasnomes = nomes.readLines().toMutableList()
                if (!verificanum(name)) {
                    println("NOME INVALIDO!!!")
                    continue
                } else if (listasnomes.contains(name)) {
                    println("Este nome ja esta inserido!")
                    continue
                } else {
                    println("Nome cadastrado.")
                    nomes.appendText("$name\n")
                }

            }

            2 -> {
                val sobrename = inserir("Sobrenome")
                val listasobrenomes = sobrenomes.readLines().toMutableList()
                if (!verificanum(sobrename)) {
                    println("SOBRENOME INVALIDO!!!")
                    continue
                }
                else if (listasobrenomes.contains(sobrename)) {
                    println("Este sobrenome ja esta inserido!")
                    continue
                }
                else {
                    println("Sobrenome cadastrado.")
                    sobrenomes.appendText("$sobrename\n")
                }

            }

            3 -> {
                println("Voce quer deletar um nome ou sobrenome?: \n Nome : 1 || Sobrenome : 0")
                val escolha = readln().toInt()

                if (escolha == 1) {
                    delet("Nome", nomes)
                    println("NOME RETIRADO COM SUCESSO!")
                } else if (escolha == 0) {
                    delet("Sobrenome", sobrenomes)
                    println("SOBRENOME RETIRADO COM SUCESSO!")
                }
            }

            4 -> {
                val listanomesOG = nomes.readLines().toMutableList()
                val listasobrenomesOG = sobrenomes.readLines().toMutableList()
                println(randomica(listanomesOG, listasobrenomesOG))
            }

            5 -> {
                val listanomesOGG = nomes.readLines().toMutableList()
                for (i in listanomesOGG) {
                    println(i)
                }
                println("\n")
            }


            6 -> {
                val listasobrenomesOGG = sobrenomes.readLines().toMutableList()
                for (i in listasobrenomesOGG) {
                    println(i)
                }
                println("\n")
            }


            7 -> {
                println("VOCE SAIU DO MENU")
                valor = false
            }

        }
    }
}