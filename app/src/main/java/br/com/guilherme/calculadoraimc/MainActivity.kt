// Pacote que organiza a classe dentro da estrutura do projeto
package br.com.guilherme.calculadoraimc

// Importações necessárias para o funcionamento do código
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
 * Classe principal que representa a primeira tela do app (Activity)
 * Herda de AppCompatActivity para compatibilidade com versões antigas do Android
 */
class MainActivity : AppCompatActivity() {

    /*
     * Método chamado quando a Activity é criada
     * @param savedInstanceState - Bundle que contém o estado anterior da Activity (se houver)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o layout XML que será usado por esta Activity
        setContentView(R.layout.activity_main)

        /*
         * Criação de uma thread secundária para executar o processo de splash
         * Usamos uma object expression para criar uma subclasse anônima de Thread
         */
        val background = object : Thread() {
            override fun run() {
                try {
                    // Pausa a execução por 3 segundos (3000 milissegundos)
                    Thread.sleep(3000)

                    // Cria uma Intent para navegar para a próxima tela (Tela2Activity)
                    val intent = Intent(baseContext, Tela2Activity::class.java)

                    // Inicia a nova Activity
                    startActivity(intent)
                } catch (e: Exception) {
                    // Trata possíveis erros imprimindo no log
                    e.printStackTrace()
                }
            }
        }
        // Inicia a execução da thread
        background.start()
    }
}