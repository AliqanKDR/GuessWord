/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.android.guesstheword.R

/**
 * ViewModel containing all the logic needed to run the game
 */
class GameViewModel : ViewModel() {

    var resource = R.drawable.guitar

    // The current word
    var word = ""

    // The current score
    var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>


    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar"
        )
        wordList.shuffle()
    }

    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    /**
     * Callback called when the ViewModel is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /** Methods for updating the UI **/
    fun onSkip() {
        score--
        nextWord()
    }
    fun onCorrect() {
        score++
        nextWord()
    }

    /**
     * Moves to the next word in the list.
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (!wordList.isEmpty()) {
            word = wordList.removeAt(0)
             resource = when (word) {
                "queen" -> R.drawable.queen
                "hospital" -> R.drawable.hospital
                "basketball" -> R.drawable.basketball
                "cat" -> R.drawable.cat
                "snail" -> R.drawable.snail
                "dog" -> R.drawable.dog
                "bag" -> R.drawable.bag
                "apple" -> R.drawable.apple
                "banana" ->R.drawable.banana
                "zebra"  ->R.drawable.zebra
                "king"  ->R.drawable.king
                "piano" -> R.drawable.piano
                "home"  ->R.drawable.home
                else -> R.drawable.hospital

            }
        }
    }
    }

