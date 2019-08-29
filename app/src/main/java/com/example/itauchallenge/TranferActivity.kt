package com.example.itauchallenge

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.itauchallenge.domain.Conta
import com.example.itauchallenge.domain.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_tranfer.*

class TranferActivity : AppCompatActivity() {
    private var user: User? = null
    private var valor: Int? = 0
    private var conta: Conta? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranfer)
        setSupportActionBar(toolbar)
        if (intent != null && intent.extras != null && intent.extras!!.getParcelable<Parcelable>("user") != null) {
            user = intent.extras!!.getParcelable<User>("user")
        }
        if (intent != null && intent.extras != null && intent.extras!!.getParcelable<Parcelable>("conta") != null) {
            conta = intent.extras!!.getParcelable<Conta>("conta")
        }

        nome.setText(user!!.getNome())

    }

    override fun onResume() {
        super.onResume()

        if(conta!!.selecionado.equals("Conta poupança")){
            contatex.setText(conta!!.selecionado + ": "+conta!!.poupanca)
        }else{
            contatex.setText(conta!!.selecionado + ": "+conta!!.corrente)
        }

        transfe.setText(""+valor)
        umreal.setOnClickListener(View.OnClickListener { view ->
            valor = valor!! +1
            transfe.setText(""+valor)
        })
        cincoreais.setOnClickListener(View.OnClickListener { view ->
            valor = valor!! +5
            transfe.setText(""+valor)
        })
        dezreais.setOnClickListener(View.OnClickListener { view ->
            valor = valor!! +10
            transfe.setText(""+valor)
        })
        confirmar.setOnClickListener(View.OnClickListener { view ->
            val builder = AlertDialog.Builder(this@TranferActivity)

            builder.setTitle("Você confirma a transferencia?")
            builder.setPositiveButton("YES"){dialog, which ->
                Toast.makeText(applicationContext,"Ok",Toast.LENGTH_SHORT).show()
                if(conta!!.selecionado.equals("Conta poupança")){
                    conta!!.poupanca = conta!!.poupanca - this!!.valor!!
                    contatex.setText(conta!!.selecionado + ": "+conta!!.poupanca)
                }else{
                    conta!!.corrente = conta!!.corrente - this!!.valor!!
                    contatex.setText(conta!!.selecionado + ": "+conta!!.corrente)
                }
            }
            builder.setNegativeButton("No"){dialog,which ->
                Toast.makeText(applicationContext,"You are not agree.",Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Cancel"){_,_ ->
                Toast.makeText(applicationContext,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        })

    }




}