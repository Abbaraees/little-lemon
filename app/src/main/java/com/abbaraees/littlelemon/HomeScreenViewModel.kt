package com.abbaraees.littlelemon

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    db: MenuDatabase
): ViewModel() {
    var menuItems = mutableListOf<MenuItemRoom>()

    init {
        viewModelScope.launch {
            menuItems = db.menuDao().getAllMenus().toMutableList()
        }
    }
}