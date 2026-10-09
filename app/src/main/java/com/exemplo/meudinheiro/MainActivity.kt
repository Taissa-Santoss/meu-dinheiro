package com.exemplo.meudinheiro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exemplo.meudinheiro.databinding.ActivityMainBinding

val gastosMock = listOf(
    Gasto("Moradia", "🏠", 700),
    Gasto("Alimentação", "🍔", 250),
    Gasto("Transporte", "🚌", 100),
    Gasto("Lazer", "🎮", 80),
    Gasto("Contas", "💡", 120)
)

val entradaMock = 3500

fun calcularTotalGastos(): Int {
    var total = 0
    gastosMock.forEach { total += it.valor }
    return total
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalGastos = calcularTotalGastos()

        binding.tvSaldo.text = getString(R.string.valor_reais, entradaMock - totalGastos)
        binding.tvEntrou.text = getString(R.string.valor_reais, entradaMock)
        binding.tvSaiu.text = getString(R.string.valor_reais, totalGastos)

        binding.tvCat1.text = "${gastosMock[0].emoji} ${gastosMock[0].categoria}"
        binding.tvVal1.text = getString(R.string.valor_reais, gastosMock[0].valor)
        binding.tvCat2.text = "${gastosMock[1].emoji} ${gastosMock[1].categoria}"
        binding.tvVal2.text = getString(R.string.valor_reais, gastosMock[1].valor)
        binding.tvCat3.text = "${gastosMock[2].emoji} ${gastosMock[2].categoria}"
        binding.tvVal3.text = getString(R.string.valor_reais, gastosMock[2].valor)

        binding.btnVerGastos.setOnClickListener {
            val intent = Intent(this, GastosActivity::class.java)
            intent.putExtra(GastosActivity.MES_KEY, "Setembro 2026")
            startActivity(intent)
        }
    }
}

data class Gasto(
    val categoria: String,
    val emoji: String,
    val valor: Int
) {
    init {
        require(valor >= 0) { "valor is not valid" }
    }
}
