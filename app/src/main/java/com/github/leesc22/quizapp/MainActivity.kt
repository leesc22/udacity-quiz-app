package com.github.leesc22.quizapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val quizCount:Int = 5
    private var correctCount:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun submitQuiz(view: View) {
        checkAllAnswer()

        Toast.makeText(this, "You got $correctCount out of $quizCount right!", Toast.LENGTH_SHORT).show()

        resetCorrectCount()
    }

    private fun checkAllAnswer() {
        checkAnswerInterest()
        checkAnswerNumeracy()
        checkAnswerCompoundInterest()
        checkAnswerInflation()
        checkAnswerDiversification()
    }

    private fun checkAnswerInterest() {
        val answerInterest = answer_interest_edit_text.text.toString().toIntOrNull()

        if (answerInterest == 102) {
            correctCount++
        }
    }

    private fun checkAnswerNumeracy() {
        val isAnswerNumeracyNumber1Checked = checkbox_answer_numeracy_number1.isChecked
        val isAnswerNumeracyNumber2Checked = checkbox_answer_numeracy_number2.isChecked
        val isAnswerNumeracyPercent1Checked = checkbox_answer_numeracy_percent1.isChecked
        val isAnswerNumeracyPercent2Checked = checkbox_answer_numeracy_percent2.isChecked

        if (!isAnswerNumeracyNumber1Checked && isAnswerNumeracyNumber2Checked && !isAnswerNumeracyPercent1Checked && isAnswerNumeracyPercent2Checked) {
            correctCount++
        }
    }

    private fun checkAnswerCompoundInterest() {
        val isAnswerCompoundInterestMore = radio_compound_interest_more.isChecked

        if (isAnswerCompoundInterestMore) {
            correctCount++
        }
    }

    private fun checkAnswerInflation() {
        val isAnswerInflationLess = radio_inflation_less.isChecked

        if (isAnswerInflationLess) {
            correctCount++
        }
    }

    private fun checkAnswerDiversification() {
        val isAnswerDiversificationMultiple = radio_diversification_multiple.isChecked

        if (isAnswerDiversificationMultiple) {
            correctCount++
        }
    }

    private fun resetCorrectCount() {
        correctCount = 0
    }
}
