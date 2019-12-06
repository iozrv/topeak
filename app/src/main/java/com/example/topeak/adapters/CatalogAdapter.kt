package com.example.topeak.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.topeak.R
import com.example.topeak.models.CatalogLab

class CatalogAdapter: RecyclerView.Adapter<CatalogAdapter.CatalogHolder>() {

    val catalogList = CatalogLab().catalogList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogHolder {

        val view: View

        view = LayoutInflater.from(parent.context).inflate(R.layout.catalog_item, parent, false)
        return CatalogHolder(view)
    }

    override fun getItemCount(): Int = catalogList.size


    override fun onBindViewHolder(holder: CatalogHolder, position: Int) {
        CatalogLab()
        holder.bind(position)


    }

    inner class CatalogHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind(position: Int){
            val idImg = itemView.findViewById<ImageView>(R.id.icon_catalog)
            val idText = itemView.findViewById<TextView>(R.id.catalog_name)
            if(position==0){
                idImg.setImageResource(R.drawable.ic_catalog_dev)
                idText.text = "${catalogList[position].name}"
            }
            else if(position==1){
                idImg.setImageResource(R.drawable.ic_catalog_design)
                idText.text = "${catalogList[position].name}"
            }
            else if(position==2){
                idImg.setImageResource(R.drawable.ic_catalog_lang)
                idText.text = "${catalogList[position].name}"
            }
        }
    }

}