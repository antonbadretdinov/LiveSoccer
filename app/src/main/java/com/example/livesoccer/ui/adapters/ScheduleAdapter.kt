package com.example.livesoccer.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livesoccer.R
import com.example.livesoccer.databinding.ScheduleItemBinding
import com.example.livesoccer.data.models.Round
import com.example.livesoccer.data.models.ScheduleModel

class ScheduleAdapter(private val schedule: ScheduleModel, private val teamId: Int)
    : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ScheduleItemBinding.bind(view)
        fun bind(model: Round, teamId: Int) = with(binding){
            val awayIndex = if(model.fixtures[0].participants[0].id == teamId) 1
            else 0

            tvNameRival.text = model.fixtures[0].participants[awayIndex].name

            tvTime.text = model.fixtures[0].starting_at
                .substringAfter('-')
                .substringBeforeLast(':')

            Glide.with(itemView).load(model.fixtures[0].participants[awayIndex].image_path)
                .into(imageRival)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.schedule_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = schedule.data?.get(0)?.rounds?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        schedule.data?.get(0)?.rounds?.get(position)?.let { holder.bind(it, teamId) }

    }
}