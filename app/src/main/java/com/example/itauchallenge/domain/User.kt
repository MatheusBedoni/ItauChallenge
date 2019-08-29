package com.example.itauchallenge.domain

import android.os.Parcel
import android.os.Parcelable
import com.example.itauchallenge.auxiliares.LibraryClass

class User  constructor( ): Parcelable {
    private var nome: String? = null
    private var ordem: Int? = null

    constructor(parcel: Parcel) : this() {
        nome = parcel.readString()
        ordem = parcel.readInt()
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeInt(this!!.ordem!!)
    }


    fun getNome(): String? {
        return nome
    }

    fun setNome(nome: String) {
        this.nome = nome
    }

    fun getOrdem(): Int? {
        return ordem
    }

    fun setOrdem(ordem: Int) {
        this.ordem = ordem
    }


    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}