package com.strawberry.pdfgenerator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kirtikumarsapplication.app.R

class ComplianceRecyclerAdapter(private val mList: List<ComplianceDetails>) :
    RecyclerView.Adapter<ComplianceRecyclerAdapter.MarksViewHolder>() {
    class MarksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val particular: TextView = view.findViewById(R.id.txt_particular_recy)
        val status: TextView = view.findViewById(R.id.txt_status_recy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_marks, parent, false)
        return MarksViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarksViewHolder, position: Int) {
        holder.particular.text = mList[position].particular
        holder.status.text = mList[position].status.toString()
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}