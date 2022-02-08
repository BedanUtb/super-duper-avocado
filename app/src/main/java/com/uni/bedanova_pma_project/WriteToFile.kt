package com.uni.bedanova_pma_project

import android.util.Log
import android.widget.Toast
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.Writer
import java.lang.Exception

fun main(args: Array<String>){

    //val message = ""
   // writeToFile(message)
    getInput("lanoooo","lon","145")
   readFile()
}


fun getInput(lan: String, lon: String, timestamp: String){
    val stringBuilder: StringBuilder = StringBuilder()
    stringBuilder.append(timestamp+","+lan+","+lon)
    val message = stringBuilder.toString()
    if(message.equals("")) {
        Log.i("Nothing saved.", message)
    }else{
        writeToFile(message)
    }
}

fun writeToFile(message: String){
    try {
        var writer = FileWriter("message.txt", true)
        writer.write(message+"\n")
        writer.close()

    }catch(ex: Exception){
        println("Exception $ex")
    }
}


fun readFile(){
    var reader = FileReader("message.txt")
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