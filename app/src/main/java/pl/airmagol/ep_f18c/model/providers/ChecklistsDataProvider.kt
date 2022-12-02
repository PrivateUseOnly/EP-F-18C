package pl.airmagol.ep_f18c.model.providers

class ChecklistsDataProvider {

    private var pickedChecklist = 0
    private var pickedPage = 0
    private var checklistLength = 0
    private var checklistPage = 0

    private fun getChecklistsSize(checklistIndex: Int, page: Int): Int {
        pickedChecklist = checklistIndex
        pickedPage = page

        checklistLength = when (pickedChecklist) {
            0 -> Checklists.firePages.size
            1 -> Checklists.hydraulicPages.size
            2 -> Checklists.oocPages.size
            3 -> Checklists.abortPages.size
            4 -> Checklists.gearPages.size
            5 -> Checklists.electricPages.size
            6 -> Checklists.enginePages.size
            7 -> Checklists.warningPages.size
            else -> 0
        }
        return checklistLength

    }

    private fun getPage(checklistIndex: Int) {
        checklistPage = when (checklistIndex) {
            0 -> Checklists.firePages[pickedPage]
            1 -> Checklists.hydraulicPages[pickedPage]
            2 -> Checklists.oocPages[pickedPage]
            3 -> Checklists.abortPages[pickedPage]
            4 -> Checklists.gearPages[pickedPage]
            5 -> Checklists.electricPages[pickedPage]
            6 -> Checklists.enginePages[pickedPage]
            7 -> Checklists.warningPages[pickedPage]
            else -> 0
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