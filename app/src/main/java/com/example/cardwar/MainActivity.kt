package com.example.cardwar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import java.util.Random

class MainActivity : AppCompatActivity() {
    val scoreToWin: Int = 50
    //Cards
    //P1
    lateinit var card1P1: ImageView
    lateinit var card2P1: ImageView
    lateinit var card3P1: ImageView
    //P2
    lateinit var card1P2: ImageView
    lateinit var card2P2: ImageView
    lateinit var card3P2: ImageView

    //Players
    lateinit var player1: TextView
    lateinit var player2: TextView

    //button deal
    lateinit var dealButton: Button

    //Random
    lateinit var random: Random

    //TEAL
    lateinit var teal: TextView

    //Victory
    lateinit var vP1: TextView
    lateinit var vP2: TextView

    //restart
    lateinit var restartButton: Button

    //Scores
    var scorePlayer1: Int = 0
    var scorePlayer2: Int = 0

    var cardArray = intArrayOf(
        R.drawable.two_of_clubs,
        R.drawable.two_of_diamonds,
        R.drawable.two_of_hearts,
        R.drawable.two_of_spades,
        R.drawable.three_of_clubs,
        R.drawable.three_of_diamonds,
        R.drawable.three_of_hearts,
        R.drawable.three_of_spades,
        R.drawable.four_of_clubs,
        R.drawable.four_of_diamonds,
        R.drawable.four_of_hearts,
        R.drawable.four_of_spades,
        R.drawable.five_of_diamonds,
        R.drawable.five_of_clubs,
        R.drawable.five_of_hearts,
        R.drawable.five_of_spades,
        R.drawable.six_of_clubs,
        R.drawable.six_of_diamonds,
        R.drawable.six_of_hearts,
        R.drawable.six_of_spades,
        R.drawable.seven_of_clubs,
        R.drawable.seven_of_diamonds,
        R.drawable.seven_of_hearts,
        R.drawable.seven_of_spades,
        R.drawable.eight_of_clubs,
        R.drawable.eight_of_diamonds,
        R.drawable.eight_of_hearts,
        R.drawable.eight_of_spades,
        R.drawable.nine_of_clubs,
        R.drawable.nine_of_diamonds,
        R.drawable.nine_of_hearts,
        R.drawable.eight_of_spades,
        R.drawable.ten_of_clubs,
        R.drawable.ten_of_diamonds,
        R.drawable.ten_of_hearts,
        R.drawable.ten_of_spades,
        R.drawable.jack_of_clubs,
        R.drawable.jack_of_clubs2,
        R.drawable.jack_of_diamonds,
        R.drawable.jack_of_diamonds2,
        R.drawable.jack_of_hearts,
        R.drawable.jack_of_hearts2,
        R.drawable.jack_of_spades,
        R.drawable.jack_of_spades2,
        R.drawable.queen_of_clubs,
        R.drawable.queen_of_clubs2,
        R.drawable.queen_of_diamonds,
        R.drawable.queen_of_diamonds2,
        R.drawable.queen_of_hearts,
        R.drawable.queen_of_hearts2,
        R.drawable.queen_of_spades,
        R.drawable.queen_of_spades2,
        R.drawable.king_of_clubs,
        R.drawable.king_of_clubs2,
        R.drawable.king_of_diamonds,
        R.drawable.king_of_diamonds2,
        R.drawable.king_of_hearts,
        R.drawable.king_of_hearts2,
        R.drawable.king_of_spades,
        R.drawable.king_of_spades2,
        R.drawable.ace_of_clubs,
        R.drawable.ace_of_diamonds,
        R.drawable.ace_of_hearts,
        R.drawable.ace_of_spades
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        random = Random()

        card1P1 = findViewById(R.id.iv_card1)
        card2P1 = findViewById(R.id.iv_card2)
        card3P1 = findViewById(R.id.iv_card3)

        card1P2 = findViewById(R.id.iv_card1_2)
        card2P2 = findViewById(R.id.iv_card2_2)
        card3P2 = findViewById(R.id.iv_card3_2)

        card1P1.setImageResource(R.drawable.black_joker)
        card2P1.setImageResource(R.drawable.black_joker)
        card3P1.setImageResource(R.drawable.black_joker)
        card1P2.setImageResource(R.drawable.black_joker)
        card2P2.setImageResource(R.drawable.black_joker)
        card3P2.setImageResource(R.drawable.black_joker)

        vP1 = findViewById(R.id.victoryP1)
        vP2 = findViewById(R.id.victoryP2)

        restartButton = findViewById(R.id.restart)
        restartButton.visibility = View.INVISIBLE

        vP1.visibility = View.INVISIBLE
        vP2.visibility = View.INVISIBLE

        player1 = findViewById(R.id.tv_player1)
        player2 = findViewById(R.id.tv_player2)

        teal = findViewById(R.id.Teal)
        teal.visibility = View.INVISIBLE

        dealButton = findViewById(R.id.deal)
        dealButton.setOnClickListener {
            teal.visibility = View.INVISIBLE
            var randomCard1P1 : Int
            var randomCard2P1 : Int
            var randomCard3P1 : Int
            do {
                randomCard1P1 = random.nextInt(cardArray.size)
                randomCard2P1 = random.nextInt(cardArray.size)
                randomCard3P1 = random.nextInt(cardArray.size)
            } while(randomCard1P1 == randomCard2P1 || randomCard1P1 == randomCard3P1 || randomCard3P1 == randomCard2P1)
            setCard(randomCard1P1, card1P1)
            setCard(randomCard2P1, card2P1)
            setCard(randomCard3P1, card3P1)

            var randomCard1P2 : Int
            var randomCard2P2 : Int
            var randomCard3P2 : Int
            do {
                randomCard1P2 = random.nextInt(cardArray.size)
                randomCard2P2 = random.nextInt(cardArray.size)
                randomCard3P2 = random.nextInt(cardArray.size)
            } while(randomCard1P2 == randomCard2P2 || randomCard1P2 == randomCard3P2 || randomCard3P2 == randomCard2P2)
            setCard(randomCard1P2, card1P2)
            setCard(randomCard2P2, card2P2)
            setCard(randomCard3P2, card3P2)
            var resP1: Int = randomCard1P1+randomCard2P1+randomCard3P1
            var resP2: Int = randomCard1P2+randomCard2P2+randomCard3P2
            if(resP1 > resP2) {
                scorePlayer1++
                player1.text = "Player 1 : $scorePlayer1 points"
                if(scorePlayer1== scoreToWin) {
                    vP1.visibility = View.VISIBLE
                    restartButton.visibility = View.VISIBLE
                    card1P1.visibility = View.INVISIBLE
                    card2P1.visibility = View.INVISIBLE
                    card3P1.visibility = View.INVISIBLE
                    card1P2.visibility = View.INVISIBLE
                    card2P2.visibility = View.INVISIBLE
                    card3P2.visibility = View.INVISIBLE
                    dealButton.visibility = View.INVISIBLE
                    restartButton.setOnClickListener {
                        restart()
                    }
                }
            } else if(resP1 < resP2){
                scorePlayer2++
                player2.text = "Player 2 : $scorePlayer2 points"
                if(scorePlayer2 == scoreToWin) {
                    vP2.visibility = View.VISIBLE
                    restartButton.visibility = View.VISIBLE
                    card1P1.visibility = View.INVISIBLE
                    card2P1.visibility = View.INVISIBLE
                    card3P1.visibility = View.INVISIBLE
                    card1P2.visibility = View.INVISIBLE
                    card2P2.visibility = View.INVISIBLE
                    card3P2.visibility = View.INVISIBLE
                    dealButton.visibility = View.INVISIBLE
                    restartButton.setOnClickListener {
                        restart()
                    }
                }
            } else {
                teal.visibility = View.VISIBLE
            }
        }
    }

    private fun setCard(num: Int, image: ImageView) {
        image.setImageResource(cardArray[num])
    }

    private fun restart() {
        vP1.visibility = View.INVISIBLE
        restartButton.visibility = View.INVISIBLE
        card1P1.visibility = View.VISIBLE
        card2P2.visibility = View.VISIBLE
        card3P1.visibility = View.VISIBLE
        card1P2.visibility = View.VISIBLE
        card2P2.visibility = View.VISIBLE
        card3P2.visibility = View.VISIBLE
        dealButton.visibility = View.VISIBLE
        scorePlayer1 = 0
        scorePlayer2 = 0
        player1.text = "Player 1 : $scorePlayer1 points"
        player2.text = "Player 2 : $scorePlayer2 points"
    }
}
