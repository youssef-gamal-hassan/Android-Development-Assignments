package com.example.assignment2

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var playerNameList = ArrayList<String>()
    var playerImageList = ArrayList<Int>()
    var clubImageList = ArrayList<Int>()
    var transferPercentageList = ArrayList<Int>()

    var clubFromImageList = ArrayList<Int>()
    var clubFromNameList = ArrayList<String>()
    var clubNameList = ArrayList<String>()

    lateinit var adapter: PlayersAdapter

    var broadcastReceiver: MyBroadcastReciever = MyBroadcastReciever()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        playerNameList.add("R. Lewandowski")
        playerNameList.add("Vini Jr.")
        playerNameList.add("K. Mbappe")
        playerNameList.add("R. Sterling")
        playerNameList.add("P. Foden")

        playerImageList.add(R.drawable.lewandowski)
        playerImageList.add(R.drawable.vini)
        playerImageList.add(R.drawable.mbappe)
        playerImageList.add(R.drawable.sterling)
        playerImageList.add(R.drawable.foden)

        clubImageList.add(R.drawable.arsenal)
        clubImageList.add(R.drawable.vigo)
        clubImageList.add(R.drawable.man_u)
        clubImageList.add(R.drawable.hotspur)
        clubImageList.add(R.drawable.liverpool)

        clubFromImageList.add(R.drawable.barca)
        clubFromImageList.add(R.drawable.madrid)
        clubFromImageList.add(R.drawable.psg)
        clubFromImageList.add(R.drawable.chelsea)
        clubFromImageList.add(R.drawable.man_city)

        transferPercentageList.add(50)
        transferPercentageList.add(30)
        transferPercentageList.add(70)
        transferPercentageList.add(60)
        transferPercentageList.add(81)

        clubFromNameList.add("FC Barcelona")
        clubFromNameList.add("Real Madrid FC")
        clubFromNameList.add("Paris Saint-German")
        clubFromNameList.add("Chelsea FC")
        clubFromNameList.add("Manchester City")

        clubNameList.add("Arsenal FC")
        clubNameList.add("RC Celta de Vigo")
        clubNameList.add("Manchester United")
        clubNameList.add("Tottenham Hotspurs")
        clubNameList.add("Liverpool FC")


        adapter = PlayersAdapter(playerNameList, playerImageList, clubImageList, clubFromImageList,transferPercentageList, clubFromNameList, clubNameList, this@MainActivity)

        recyclerView.adapter = adapter



    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this@MainActivity, MusicPlayer::class.java)
        MusicPlayer.myBackgroundMusic(this@MainActivity, intent)

        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        this.registerReceiver(broadcastReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        this.unregisterReceiver(broadcastReceiver)
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this@MainActivity, "Application is resumed", Toast.LENGTH_LONG).show()
    }



}