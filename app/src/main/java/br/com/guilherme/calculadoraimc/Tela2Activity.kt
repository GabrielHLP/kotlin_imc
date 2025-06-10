// Pacote que organiza a classe dentro da estrutura do projeto
package br.com.guilherme.calculadoraimc

// Importações necessárias para o funcionamento do código
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_tela2.*

/*
 * Classe principal que representa a tela de cálculo de IMC
 * Herda de AppCompatActivity para compatibilidade com versões antigas do Android
 */
class Tela2Activity : AppCompatActivity() {

    // Declaração de variáveis usando lateinit (serão inicializadas posteriormente)
    lateinit var seekBar: SeekBar  // SeekBar para peso
    lateinit var value: TextView   // TextView que exibe o peso
    lateinit var slider: SeekBar   // SeekBar para altura
    lateinit var Texte: TextView   // TextView que exibe a altura

    /*
     * Método chamado quando a Activity é criada
     * @param savedInstanceState - Bundle que contém o estado anterior da Activity (se houver)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o layout XML que será usado por esta Activity
        setContentView(R.layout.activity_tela2)

        // Vinculando os componentes do layout às variáveis
        seekBar = findViewById(R.id.sb_Slider) as SeekBar
        slider = findViewById(R.id.sb_slider2) as SeekBar
        value = findViewById(R.id.txvResultado) as TextView
        Texte = findViewById(R.id.txvResultado2) as TextView

        // Configuração da primeira SeekBar (para peso)
        seekBar.max = 300  // Define valor máximo (300kg)

        // Listener para detectar mudanças na SeekBar de peso
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                value.text = progress.toString()  // Atualiza TextView com o valor atual
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Não implementado
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Não implementado
            }
        })

        // Configuração da segunda SeekBar (para altura)
        slider.max = 300  // Define valor máximo (300cm)

        // Listener para detectar mudanças na SeekBar de altura
        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Texte.text = progress.toString()  // Atualiza TextView com o valor atual
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Não implementado
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Não implementado
            }
        })

        // Configuração do Spinner para seleção de sexo
        val listadeSexo = arrayListOf<String>()
        listadeSexo.add("masculino")
        listadeSexo.add("feminino")

        // Criando adaptador para o Spinner
        val sexoAdapter = ArrayAdapter(this@Tela2Activity,
                android.R.layout.simple_spinner_dropdown_item,
                listadeSexo)
        spnSexo.adapter = sexoAdapter

        // Configuração do botão que exibe a tabela de IMC
        var btntabela = findViewById(R.id.btntabela) as Button
        btntabela.setOnClickListener() {
            val alerta = AlertDialog.Builder(this@Tela2Activity)
            alerta.setTitle("aperte fora do alerta para fechar")
            alerta.setMessage(
                    "Entre 17 e 18,49\tAbaixo do peso\n" +
                            "Entre 18,5 e 24,99\tPeso normal\n" +
                            "Entre 25 e 29,99\tAcima do peso\n" +
                            "Entre 30 e 34,99\tObesidade I")
            alerta.show()
        }

        // Configuração do botão que calcula o IMC
        var btnCalcular = findViewById(R.id.btnCalcular) as Button
        btnCalcular.setOnClickListener() {
            // Obtém valores de peso e altura
            val peso = txvResultado.text.toString().toDouble()
            val altura = txvResultado2.text.toString().toDouble()

            // Calcula IMC (peso / altura²)
            var resultado = (peso / (altura * altura)).toString()

            // Exibe resultado em AlertDialog
            val builder = AlertDialog.Builder(this@Tela2Activity)
            builder.setTitle("Resultado")
            builder.setMessage(" seu imc: $resultado")
            builder.show()
        }
    }
}