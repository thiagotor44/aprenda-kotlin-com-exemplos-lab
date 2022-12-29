// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Niveis { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val niveis: Niveis) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
         inscritos.add(usuario)
    }
    
    fun imprimirListaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun imprimirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    //cursos individuais
    val moduloJava = ConteudoEducacional("curso java", 120)
    val moduloKotlin = ConteudoEducacional("curso kotlin", 60)
    
    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(moduloJava)
    listConteudos.add(moduloKotlin)
    
    //formação completa com todos os cursos
    val formacaoAndroid = Formacao("Formação Android Developer", listConteudos, Niveis.INTERMEDIARIO)
    val formacaoKotlin = Formacao("Formação Kotlin Developer", listConteudos, Niveis.BASICO)

    //Criar lista de usuarios
    val Thiago = Usuario("Thiago", "Thiago@gmail.com")
    val Sarah = Usuario("Sarah", "Sarah@gmail.com")
    
    //matriculando usuarios na formação
    formacaoKotlin.matricular(Thiago)
    formacaoAndroid.matricular(Sarah)
    
    println("======================================")
    println("Dados da formação")
    println("${formacaoAndroid.nome} - ${formacaoAndroid.niveis}")
    println("${formacaoKotlin.nome} - ${formacaoKotlin.niveis}")
    println("Grade formação")
    println(formacaoAndroid.imprimirGradeFormacao())
    println(formacaoKotlin.imprimirGradeFormacao())
    println("=======================================")
    println("Lista de inscritos")
    println(formacaoAndroid.imprimirListaInscritos())
    println(formacaoKotlin.imprimirListaInscritos())}
    