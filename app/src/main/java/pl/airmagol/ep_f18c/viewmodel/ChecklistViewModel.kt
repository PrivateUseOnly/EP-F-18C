package pl.airmagol.ep_f18c.viewmodel

import androidx.lifecycle.ViewModel
import pl.airmagol.ep_f18c.model.providers.ChecklistsDataProvider

class ChecklistViewModel : ViewModel() {

    private val allChecklists = ChecklistsDataProvider()
    private var screenReset = "gone"
    var pickedList = 0
    var currentChecklistIndex = 0
    var currentIndex = 0
    private var page = 0

    fun showChecklistPage(checklistIndex: Int, pageNumber: Int): Int {
        pickedList = checklistIndex
        currentChecklistIndex = checklistIndex
        currentIndex = pageNumber
        screenReset = "visible"
        page = allChecklists.getChecklists(currentChecklistIndex, currentIndex)
        return page
    }

    fun clear() {
        pickedList = 0
        currentIndex = 0
        currentChecklistIndex = 0
        page = 0
    }

    fun nextPage(): Int {
        val result = allChecklists.getNextPage()
        currentIndex = allChecklists.pickedPage
        return result
    }

}