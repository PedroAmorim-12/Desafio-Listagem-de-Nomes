import java.io.File

fun verificanum(lag : String):Boolean{
   return lag.toIntOrNull() == null
}

fun correcao (word: String) : String {
    var word = word
    word = word.replace(" ","")
    word = word.lowercase()
    word = word.replaceFirstChar {it.uppercase()}

    return word
}


fun delet(tipo:String ,listanomes: File){
    val lista = listanomes.readLines().toMutableList()
    println("Qual $tipo voce quer deletar?")
    var ns = readLine().toString()
    ns = correcao(ns)

    if(!lista.contains(ns)){
        println("ESSE $tipo NAO ESTA INSERIDO!!!")
        return
    }

    else {
        val rem = lista.remove(ns)
        listanomes.writeText(lista.joinToString("\n"))
    }

}


fun randomica(nomes: List<String>, sobrenomes: List<String>): String {
    return "Nome ${nomes.random()} ${sobrenomes.random()}"
}

fun inserir(tipo : String): String {

        println("Insira seu $tipo: ")
        var ns = readLine().toString()
        ns = correcao(ns)

        return ns

}


fun menu(): Int{
    println("Menu: \n O que voce deseja fazer?: \n 1-Inserir nome. \n 2-Inserir sobrenomes. \n 3- Deletar nome/sobrenome \n 4-Gerar nome completo aleatorio \n 5- Listar Nomes \n 6- Listar Sobrenomes \n 7-Sair")
    val acao = readLine()!!.toInt()
    return acao
}