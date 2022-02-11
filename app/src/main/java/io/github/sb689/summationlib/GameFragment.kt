package io.github.sb689.summationlib


import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import io.github.sb689.summationlib.databinding.FragmentGameBinding

import kotlin.random.Random


class GameFragment : Fragment() {

    data class Quiz(
        val qText: String,
        val options: List<String>
    )

    private  final val TAG: String = "GameFragment"
    lateinit var questions : List<String>
    lateinit var answers : MutableList<String>
    lateinit var currentqs : String
    private var qsIndex = 0
    private var numQuestions = 3
    private lateinit var correctAns : String
    private  var qsNo : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false )
        binding.game = this
        // initialize qs array
        questions = resources.getStringArray(R.array.questions).toList()
        Log.d(TAG, "questions size = " + questions.size)
        qsNo = Random(System.nanoTime()).nextInt(0, questions.size)
        Log.d(TAG, "randomly choosen qsNo = $qsNo")

        setQuestion()

        binding.btnSubmit.setOnClickListener { view: View ->
            val checked = binding.ansRadioGroup.checkedRadioButtonId
//            if (checked != -1) {
//                var ansIndex = 0;
//                when (checked) {
//                    R.id.first_ans -> ansIndex = 0
//                    R.id.second_ans -> ansIndex = 1
//                    R.id.third_ans -> ansIndex = 2
//                }
//                Log.d(TAG, "ansIndex = $ansIndex, correctAns = $correctAns")
//
//                if (answers[ansIndex].equals(correctAns)) {
//                    qsIndex++;
//                    if (qsIndex < numQuestions) {
//                        qsNo = (qsNo + 1) % questions.size
//                        Log.d(TAG, "qsNo = $qsNo")
//                        currentqs = questions[qsNo]
//                        setQuestion()
//                        binding.invalidateAll()
//                    } else {
//                        view.findNavController().navigate(
//                            GameFragmentDirections.actionGameFragmentToGameCompleteFragment(true)
//                        )
//                    }
//                } else {
//                    view.findNavController().navigate(
//                        GameFragmentDirections.actionGameFragmentToGameCompleteFragment(false)
//                    )
//                }
//            }
        }

        return binding.root
    }

    fun setQuestion()
    {

        currentqs = questions.get(qsNo)
        Log.d(TAG, "currentqs = $currentqs")
        when(qsNo){
            0 -> answers = resources.getStringArray(R.array.ans_1).toMutableList()
            1 -> answers = resources.getStringArray(R.array.ans_2).toMutableList()
            2 -> answers = resources.getStringArray(R.array.ans_3).toMutableList()
            3 -> answers = resources.getStringArray(R.array.ans_4).toMutableList()
            4 -> answers = resources.getStringArray(R.array.ans_5).toMutableList()
            5 -> answers = resources.getStringArray(R.array.ans_6).toMutableList()
        }
        correctAns = answers[0]
        answers.shuffle()

    }


}