package pl.airmagol.ep_f18c.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import pl.airmagol.ep_f18c.databinding.ActivityMainBinding
import pl.airmagol.ep_f18c.viewmodel.ChecklistViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ChecklistViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this)[ChecklistViewModel::class.java]
        binding.btn1Fire.setOnClickListener { showSelectedChecklist(1) }
        binding.btn2Hydraulic.setOnClickListener { showSelectedChecklist(2) }
        binding.btn3Ooc.setOnClickListener { showSelectedChecklist(3) }
        binding.btn4Abort.setOnClickListener { showSelectedChecklist(4) }
        binding.btn5Gear.setOnClickListener { showSelectedChecklist(5) }
        binding.btn6Electrical.setOnClickListener { showSelectedChecklist(6) }
        binding.btn7Engine.setOnClickListener { showSelectedChecklist(7) }
        binding.btn8Warn.setOnClickListener { showSelectedChecklist(8) }
        binding.btnBackHome.setOnClickListener { setChecklistGone() }
        binding.btnNext.setOnClickListener { btnNextOnClick() }

        binding.ivChecklist.setImageResource(
            viewModel.showChecklistPage(
                viewModel.currentChecklistIndex,
                viewModel.currentIndex
            )
        )
        if (viewModel.pickedList != 0) {
            setChecklistVisible()
        }


    }


    private fun showSelectedChecklist(checklistIndex: Int) {
        val startingPage = 0
        binding.ivChecklist.setImageResource(
            viewModel.showChecklistPage(
                checklistIndex,
                startingPage
            )
        )
        setChecklistVisible()
    }

    private fun setChecklistVisible() {
        binding.llMenu.visibility = View.GONE
        binding.btnBackHome.visibility = View.VISIBLE
        binding.ivChecklist.visibility = View.VISIBLE
        binding.btnNext.visibility = View.VISIBLE

    }

    private fun setChecklistGone() {
        binding.llMenu.visibility = View.VISIBLE
        binding.btnBackHome.visibility = View.GONE
        binding.ivChecklist.visibility = View.GONE
        binding.btnNext.visibility = View.GONE
        viewModel.clear()
    }

    private fun btnNextOnClick() {

        binding.ivChecklist.setImageResource(
            viewModel.nextPage()
        )
    }
}