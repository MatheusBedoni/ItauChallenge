package com.example.itauchallenge

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.itauchallenge.Fragment.OrderFragment
import com.example.itauchallenge.domain.Conta
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var conta: Conta? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        conta = Conta()
        conta!!.poupanca = 50000.0
        conta!!.corrente = 10000.0
        var frag: OrderFragment? = supportFragmentManager.findFragmentByTag("mainFrag") as? OrderFragment
        if (frag == null) {
            frag = OrderFragment()
            Log.i("TAG", "fragment")
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag")
            ft.commit()
        }
    }

    @SuppressLint("ResourceAsColor")
    override fun onResume() {
        super.onResume()
        contapoupança.setText("Conta Poupanca: "+conta!!.poupanca)
        contacorrente.setText("Conta Corrente: "+conta!!.corrente)

        contapoupança.setOnClickListener(View.OnClickListener { view ->
            contapoupança.setBackgroundResource(R.color.colorPrimary)
            contacorrente.setBackgroundResource(R.color.colorWrite)
            conta!!.selecionado = "Conta poupança"
        })
        contacorrente.setOnClickListener(View.OnClickListener { view ->
            contacorrente.setBackgroundResource(R.color.colorPrimary)
            contapoupança.setBackgroundResource(R.color.colorWrite)
            conta!!.selecionado = "Conta corrente"
        })
    }
    fun getConta(): Conta{
        return this!!.conta!!
    }
}
