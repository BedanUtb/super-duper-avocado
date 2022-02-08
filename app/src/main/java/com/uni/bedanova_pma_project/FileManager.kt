package com.uni.bedanova_pma_project

import android.util.Log
import java.io.FileReader
import java.io.FileWriter
import java.lang.Exception

class FileManager {
    fun main(args: Array<String>){
        input("lan","lon","14")
        fromFile()
    }

    fun input(lan: String, lon: String, timestamp: String){
        val stringBuilder: StringBuilder = StringBuilder()
        stringBuilder.append(timestamp+","+lan+","+lon)
        val message = stringBuilder.toString()
        if(message.equals("")) {
            Log.i("Nothing saved.", message)
        }else{
            toFile(message)
        }
    }

    fun toFile(message: String){
        try {
            var writer = FileWriter("message2.txt", true)
            writer.write(message+"\n")
            writer.close()

        }catch(ex: Exception){
            println("Exception $ex")
        }
    }


    fun fromFile(){
        var reader = FileReader("message2.txt")
        var readMessage: String?= null
        var char: Int?
        try {
            do{
                char=reader.read()
                print(char.toChar())

            }while(char!= -1)

        }catch(ex: Exception){
            print(ex.message)
        }
    }
}

