package com.example.control

import com.example.business.ConvidadoBusiness
import com.example.entity.Convite

class Portaria {


    private val convidadoBusiness = ConvidadoBusiness()

    init{
        this.controle()
        println(controle())
    }

    private fun controle() : String{
        val idade = Console.readInt("Digite sua idade: ")
        val convidado = Convite(idade = idade)
        if(!convidadoBusiness.maiorDeIdade(idade)){
         return ("Negado. Menores de idade não são permitidos.")
        }

        convidado.tipo = Console.readString("Qual o tipo de convite: ")
        if(!convidadoBusiness.tipoValido(convidado.tipo)){
            return "Negado! Convite inválido"
        }

        convidado.codigo = Console.readString("Qual o código do convite: ")
        if(!convidadoBusiness.convidadoValido(convidado)){
            return "Negado! Código inválido"
        }

        return "Welcome!"
    }

}