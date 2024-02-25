// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60) {
    override fun toString(): String {
        return "\nCurso de ${nome}, nível ${nivel.name.lowercase()}, ${duracao} minutos"
    }
}

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado(a) na formação ${nome}!")
        }
    }

    override fun toString(): String {
        return "Formação ${nome}, nível ${nivel.name.lowercase()}, conteúdos programáticos: ${conteudos}\n"
    }
}

fun main() {
    val usuario = Usuario("Maria")
    val usuario2 = Usuario("José")
    val usuario3 = Usuario("Joana")

    val conteudoEducacional = ConteudoEducacional("Introdução a Git e Github", Nivel.BASICO, duracao = 120)
    val conteudoEducacional2 = ConteudoEducacional("Introdução à linguagem Kotlin e Orientação de Objetos", Nivel.BASICO, duracao = 180)

    val formacao = Formacao("Desenvolvimento em Kotlin", Nivel.BASICO, listOf(conteudoEducacional, conteudoEducacional2))
    println(formacao.toString())

    formacao.matricular(usuario, usuario2, usuario3)
}
