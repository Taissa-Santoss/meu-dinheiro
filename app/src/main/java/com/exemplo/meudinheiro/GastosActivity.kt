package com.exemplo.meudinheiro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exemplo.meudinheiro.databinding.ActivityGastosBinding
import com.exemplo.meudinheiro.databinding.ItemGastoBinding
class GastosActivity : AppCompatActivity() {
    companion object {
         const val MES_KEY = "mes"
    }

    private lateinit var binding: ActivityGastosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvMes.text = intent.getStringExtra(MES_KEY)

        val total = calcularTotalGastos()

        gastosMock.forEach { gasto ->
            val itemBinding = ItemGastoBinding.inflate(layoutInflater, binding.llContainer, false)
            itemBinding.tvCategoria.text = "${gasto.emoji} ${gasto.categoria}"
            itemBinding.tvValor.text = getString(R.string.valor_reais, gasto.valor)
            itemBinding.barra.progress = gasto.valor * 100 / total
            binding.llContainer.addView(itemBinding.root)
        }

        binding.tvTotal.text = getString(R.string.total_reais, total)
    }
}
