package com.example.livesoccer.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livesoccer.R
import com.example.livesoccer.databinding.TeamItemBinding
import com.example.livesoccer.data.models.TeamListModel
import com.example.livesoccer.data.models.TeamModel
import com.example.livesoccer.ui.adapters.listener.SelectListener

class TeamsAdapter(private val teams: TeamListModel, private val listener: SelectListener)
    : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = TeamItemBinding.bind(view)

        fun bind(model: TeamModel, listener: SelectListener) = with(binding){
            tvTeamName.text = model.name

            Glide.with(itemView.context).load(model.image_path).into(imageTeam)

            itemView.setOnClickListener {
                listener.onItemClicked(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = teams.data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(teams.data[position], listener)
    }
}