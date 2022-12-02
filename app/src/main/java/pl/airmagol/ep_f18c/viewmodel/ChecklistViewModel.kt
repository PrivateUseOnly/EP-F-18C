package pl.airmagol.ep_f18c.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.airmagol.ep_f18c.model.Checklist
import pl.airmagol.ep_f18c.model.providers.ChecklistsDataProvider

class ChecklistViewModel : ViewModel() {

    private val checklistData = MutableLiveData<Checklist>()
    private val allChecklists = ChecklistsDataProvider()
    private var screenReset = "gone"

    private var currentChecklistIndex = 0
    private var currentIndex = 0
    var page = 0

    fun showChecklistPage(checklistIndex: Int, pageNumber: Int): Int {

        currentChecklistIndex= checklistIndex
        currentIndex = pageNumber
        screenReset = "visible"
        page = allChecklists.getChecklists(currentChecklistIndex, currentIndex)
        return page
    }

    fun clear(){
        currentIndex = 0
        currentChecklistIndex = 0
        page = 0
    }

    fun nextPage(): Int{
        return allChecklists.getNextPage()
    }



}