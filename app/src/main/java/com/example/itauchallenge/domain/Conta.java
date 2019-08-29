package com.example.itauchallenge.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Conta  implements Parcelable{

    private double corrente;
    private double poupanca;
    private String selecionado;

    protected Conta(Parcel in) {
        corrente = in.readDouble();
        poupanca = in.readDouble();
        selecionado = in.readString();
    }
public Conta(){}
    public static final Creator<Conta> CREATOR = new Creator<Conta>() {
        @Override
        public Conta createFromParcel(Parcel in) {
            return new Conta(in);
        }

        @Override
        public Conta[] newArray(int size) {
            return new Conta[size];
        }
    };

    public double getCorrente() {
        return corrente;
    }

    public double getPoupanca() {
        return poupanca;
    }

    public String getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(String selecionado) {
        this.selecionado = selecionado;
    }

    public void setCorrente(double corrente) {
        this.corrente = corrente;
    }

    public void setPoupanca(double poupanca) {
        this.poupanca = poupanca;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(corrente);
        dest.writeDouble(poupanca);
        dest.writeString(selecionado);
    }
}
