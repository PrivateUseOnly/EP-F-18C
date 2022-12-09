package pl.airmagol.ep_f18c.model.providers

class ChecklistsDataProvider {

    private var pickedChecklist = 0
    var pickedPage = 0
    private var checklistLength = 0
    private var checklistPage = 0

    private fun getChecklistsSize(checklistIndex: Int, pageIndex: Int): Int {
        pickedChecklist = checklistIndex
        pickedPage = pageIndex

        checklistLength = when (pickedChecklist) {
            1 -> Checklists.firePages.size
            2 -> Checklists.hydraulicPages.size
            3 -> Checklists.oocPages.size
            4 -> Checklists.abortPages.size
            5 -> Checklists.gearPages.size
            6 -> Checklists.electricPages.size
            7 -> Checklists.enginePages.size
            8 -> Checklists.warningPages.size
            else -> 0
        }
        return checklistLength

    }

    private fun getPage(checklistIndex: Int) {
        checklistPage = when (checklistIndex) {
            1 -> Checklists.firePages[pickedPage]
            2 -> Checklists.hydraulicPages[pickedPage]
            3 -> Checklists.oocPages[pickedPage]
            4 -> Checklists.abortPages[pickedPage]
            5 -> Checklists.gearPages[pickedPage]
            6 -> Checklists.electricPages[pickedPage]
            7 -> Checklists.enginePages[pickedPage]
            8 -> Checklists.warningPages[pickedPage]
            else -> Checklists.firePages[pickedPage]
        }
    }

    fun getChecklists(checklistIndex: Int, page: Int): Int {
        getChecklistsSize(checklistIndex, page)
        getPage(pickedChecklist)
        return (checklistPage)
    }

    fun getNextPage(): Int {
        if (checklistLength > (pickedPage + 1)) {
            pickedPage++
        } else pickedPage = 0
        return getChecklists(pickedChecklist, pickedPage)
    }
}