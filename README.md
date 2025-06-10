Calculadora de IMC - Projeto Finalizado
📝 Descrição
Este projeto é uma calculadora de Índice de Massa Corporal (IMC) desenvolvida para Android. O aplicativo permite que os usuários:

Ajustem seu peso e altura usando controles deslizantes (SeekBar)

Selecione seu sexo (masculino/feminino)

Visualize uma tabela de referência de IMC

Calcule e exiba seu IMC com base nos valores inseridos

⚙️ Funcionalidades
Controles deslizantes intuitivos para peso (0-300kg) e altura (0-300cm)

Seleção de sexo através de um spinner

Cálculo automático do IMC (peso/altura²)

Tabela de referência incorporada com classificações de IMC

Interface simples e direta ao ponto

🛠️ Tecnologias Utilizadas
Linguagem: Kotlin

Plataforma: Android

Ferramentas:

Android Studio

Gradle

XML para layouts

📊 Fórmula do IMC
text
IMC = peso (kg) / (altura (m) × altura (m))
Observação: No código atual, a altura é tratada em centímetros (necessário converter para metros no cálculo)

⚠️ Limitações Conhecidas
A altura é tratada como centímetros no controle, mas a fórmula requer metros

O sexo selecionado não influencia o cálculo

Não há tratamento para divisão por zero (se altura = 0)

O resultado não é formatado (pode mostrar muitas casas decimais)

📁 Estrutura do Projeto
text
app/
├── src/
│   ├── main/
│   │   ├── java/br/com/guilherme/calculadoraimc/
│   │   │   ├── MainActivity.kt      # Tela de splash
│   │   │   └── Tela2Activity.kt    # Tela principal de cálculo
│   │   └── res/
│   │       ├── layout/
│   │       │   ├── activity_main.xml
│   │       │   └── activity_tela2.xml
└── build.gradle
🔄 Status do Projeto
Este projeto está finalizado e não receberá atualizações futuras. Foi desenvolvido como um exercício de aprendizado e mantido em seu estado original para fins de demonstração.

📄 Licença
Este projeto não possui licença específica. O código é disponibilizado como referência educacional.
