package com.example.itauchallenge.Fragment

import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itauchallenge.MainActivity
import com.example.itauchallenge.R
import com.example.itauchallenge.TranferActivity
import com.example.itauchallenge.adapter.OrderAdapter
import com.example.itauchallenge.adapter.OrderViewHolder
import com.example.itauchallenge.auxiliares.LibraryClass
import com.example.itauchallenge.domain.Conta
import com.example.itauchallenge.domain.User
import com.firebase.client.Firebase
import com.firebase.client.DataSnapshot
import com.firebase.client.ValueEventListener




class OrderFragment : Fragment() {


    private var recyclerView: RecyclerView? = null
    private var list: List<User>? = null
    private var user: User? = null
    private var adapter: OrderAdapter? = null
    private var firebase: Firebase? = null
    private var conta: Conta? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_order, container, false)
        //O app cria as listas usando o Recycler View
        user = User()
        firebase = LibraryClass.getFirebase().child("user")
        recyclerView = view.findViewById(R.id.rv_list)
        recyclerView!!.setHasFixedSize(true)


        return view
    }

    override fun onResume() {
        super.onResume()
        recyclerView!!.setVisibility(View.VISIBLE)
        val llm = LinearLayoutManager(activity)
        llm.orientation = LinearLayoutManager.VERTICAL

        recyclerView!!.setLayoutManager(llm)
        init()
        recyclerView!!.setAdapter(adapter)

    }

    public fun init() {
        adapter = object : OrderAdapter(
            User::class.java,
            R.layout.item_order,
            OrderViewHolder::class.java,
            firebase) {
            protected override fun populateViewHolder(produtoresViewHolder: OrderViewHolder, produtor: User, i: Int) {
                super.populateViewHolder(produtoresViewHolder, produtor, i)
                produtoresViewHolder.tvNome.setText(produtor.getNome())
                conta = (activity as MainActivity).getConta()
                produtoresViewHolder.itemView.setOnClickListener(View.OnClickListener {
                    if(produtor.getNome().equals("A") || produtor.getNome().equals("C") || produtor.getNome().equals("J") || produtor.getNome().equals("L")){

                    }else{
                        val intent = Intent(activity, TranferActivity::class.java)
                        intent.putExtra("user", produtor)
                        intent.putExtra("conta", conta)
                        activity!!.startActivity(intent)
                    }

                })
            }
        }

    }


}