package com.example.assignment2

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class PlayerInfo : AppCompatActivity() {
    lateinit var playerName: TextView
    lateinit var cClubName: TextView
    lateinit var iClubName: TextView
    lateinit var dob: TextView
    lateinit var contract: TextView
    lateinit var nat: TextView
    lateinit var age: TextView
    lateinit var height: TextView
    lateinit var pos: TextView
    lateinit var foot: TextView

    lateinit var playerImage: ImageView
    lateinit var clubFromImage: ImageView
    lateinit var clubToImage: ImageView

    var broadcastReceiver: MyBroadcastReciever = MyBroadcastReciever()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_info)

        playerName = findViewById(R.id.playerNameTextView)
        cClubName = findViewById(R.id.cClubTV2)
        iClubName = findViewById(R.id.iClubTV2)
        dob = findViewById(R.id.dobTV2)
        contract = findViewById(R.id.contractTV2)
        nat = findViewById(R.id.natTV2)
        age = findViewById(R.id.ageTV2)
        height = findViewById(R.id.heightTV2)
        pos = findViewById(R.id.posTV2)
        foot = findViewById(R.id.footTV2)

        playerImage = findViewById(R.id.playerImageIV)
        clubFromImage = findViewById(R.id.clubFromImage)
        clubToImage = findViewById(R.id.clubToImage)

        playerName.text = intent.getStringExtra("playerName")
        playerImage.setImageResource(intent.getIntExtra("playerImage", 0))
        clubFromImage.setImageResource(intent.getIntExtra("clubFromImage", 0))
        clubToImage.setImageResource(intent.getIntExtra("clubImage", 0))
        cClubName.text = intent.getStringExtra("clubFromName")
        iClubName.text = intent.getStringExtra("clubName")

        when(playerName.text.toString()){
            "R. Lewandowski" -> {
                dob.text = "21.08.1988"
                contract.text = "Jun 30, 2026"
                nat.text = "Poland"
                age.text = "35"
                height.text = "1,85m"
                pos.text = "Centre-Forward"
                foot.text = "Right"
            }
            "Vini Jr."->{
                dob.text = "12.07.2000"
                contract.text = "Jul 30, 2027"
                nat.text = "Brazil"
                age.text = "23"
                height.text = "1,76m"
                pos.text = "Left-Winger"
                foot.text = "Right"
            }
            "K. Mbappe"->{
                dob.text = "20.12.1998"
                contract.text = "Jun 30, 2024"
                nat.text = "France"
                age.text = "25"
                height.text = "1,78m"
                pos.text = "Centre-Forward"
                foot.text = "Right"
            }
            "R. Sterling"->{
                dob.text = "08.12.1994"
                contract.text = "Jun 30, 2027"
                nat.text = "England"
                age.text = "29"
                height.text = "1,70m"
                pos.text = "Left-Winger"
                foot.text = "Right"
            }
            "P. Foden"->{
                dob.text = "28.05.2000"
                contract.text = "Jun 30, 2027"
                nat.text = "England"
                age.text = "23"
                height.text = "1,71m"
                pos.text = "Right-Winger"
                foot.text = "Left"
            }
            else ->{}
        }
    }
    override fun onStart() {
        super.onStart()

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
        Toast.makeText(this@PlayerInfo, "Application is resumed", Toast.LENGTH_LONG).show()
    }

}