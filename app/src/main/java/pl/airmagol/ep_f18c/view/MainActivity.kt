package pl.airmagol.ep_f18c.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pl.airmagol.ep_f18c.databinding.ActivityMainBinding
import pl.airmagol.ep_f18c.viewmodel.ChecklistViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val checklistViewModel = ChecklistViewModel()
    private var imageVisibility = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1Fire.setOnClickListener { showSelectedChecklist(0, 0) }
        binding.btn2Hydraulic.setOnClickListener { showSelectedChecklist(1, 0) }
        binding.btn3Ooc.setOnClickListener { showSelectedChecklist(2, 0) }
        binding.btn4Abort.setOnClickListener { showSelectedChecklist(3, 0) }
        binding.btn5Gear.setOnClickListener { showSelectedChecklist(4, 0) }
        binding.btn6Electrical.setOnClickListener { showSelectedChecklist(5, 0) }
        binding.btn7Engine.setOnClickListener { showSelectedChecklist(6, 0) }
        binding.btn8Warn.setOnClickListener { showSelectedChecklist(7, 0) }
        binding.btnBack?.setOnClickListener { setChecklistGone() }
        binding.btnNextPage?.setOnClickListener { btnNextOnClick() }
    }

    private fun showSelectedChecklist(checklistIndex: Int, pageIndex: Int) {
        binding.ivChecklist?.setImageResource(
            checklistViewModel.showChecklistPage(
                checklistIndex,
                pageIndex
            )
        )
        setChecklistVisible()
    }

    private fun setChecklistVisible() {
        binding.llMenu?.visibility = View.GONE
        binding.llChecklist?.visibility = View.VISIBLE

    }

    private fun setChecklistGone() {
        binding.llMenu?.visibility = View.VISIBLE
        binding.llChecklist?.visibility = View.GONE
        checklistViewModel.clear()
    }

    private fun btnNextOnClick() {

        binding.ivChecklist?.setImageResource(
            checklistViewModel.nextPage()
        )
    }
}