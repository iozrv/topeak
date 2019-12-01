package com.example.topeak.models


data class Catalog(val name: String)

class CatalogLab(){
    val catalogList: MutableList<Catalog>

    init{
        catalogList = mutableListOf()
        for(i in 0..2){
            if(i==0){
                val catalog = Catalog("Разработка")
                catalogList.add(catalog)
            }
            else if(i==1){
                val catalog = Catalog("Языки")
                catalogList.add(catalog)
            }
            else if(i==2){
                val catalog = Catalog("Дизайн")
                catalogList.add(catalog)
            }


        }
    }

}