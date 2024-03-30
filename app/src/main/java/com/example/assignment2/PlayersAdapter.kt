package com.example.assignment2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class PlayersAdapter(
    var playerNameList: ArrayList<String>,
    var playerImageList: ArrayList<Int>,
    var clubImageList: ArrayList<Int>,
    var clubFromImageList: ArrayList<Int>,
    var transferPercentageList: ArrayList<Int>,
    var clubFromNameList:ArrayList<String>,
    var clubNameList: ArrayList<String>,
    var context: Context
) : RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>()
{
    class PlayerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cardView: CardView = itemView.findViewById(R.id.cardView)
        var playerTV: TextView = itemView.findViewById(R.id.playerNameTV)
        var playerImage: ImageView = itemView.findViewById(R.id.playerImage)
        var clubImage: ImageView = itemView.findViewById(R.id.clubImage)
        var transferPercentageTV: TextView = itemView.findViewById(R.id.transferPercentageTV)
        var arrow_up_down:ImageView= itemView.findViewById(R.id.arrowUp_Down)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.player_view, parent, false)

        return PlayerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playerNameList.size
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.playerTV.text = playerNameList.get(position)
        holder.playerImage.setImageResource(playerImageList.get(position))
        holder.clubImage.setImageResource(clubImageList.get(position))
        holder.transferPercentageTV.text = transferPercentageList.get(position).toString()

        if(transferPercentageList.get(position) >= 50){
            holder.arrow_up_down.setImageResource(R.drawable.arrow_up)
        }else{
            holder.arrow_up_down.setImageResource(R.drawable.arrow_down)
        }

        holder.cardView.setOnClickListener{
            var intent = Intent(context, PlayerInfo::class.java)
            intent.putExtra("playerName", playerNameList.get(position))
            intent.putExtra("clubFromImage", clubFromImageList.get(position))
            intent.putExtra("clubImage", clubImageList.get(position))
            intent.putExtra("playerImage", playerImageList.get(position))
            intent.putExtra("clubFromName", clubFromNameList.get(position))
            intent.putExtra("clubName", clubNameList.get(position))

            startActivity(context, intent, null)

        }


    }

}