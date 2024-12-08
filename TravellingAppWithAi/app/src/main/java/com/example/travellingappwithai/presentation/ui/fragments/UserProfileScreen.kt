package com.example.travellingappwithai.presentation.ui.fragments
// presentation/ui/screens/UserProfileScreen.kt


import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travellingappwithai.domain.models.User
import com.example.travellingappwithai.presentation.viewmodel.UserViewModel

@Composable
fun UserProfileScreen(
    userId: Int,
    userViewModel: UserViewModel = viewModel()
) {
    // Kullanıcı profilini almak için ViewModel'den veri çekiyoruz
    val userProfile by userViewModel.userProfile.collectAsState()

    // Kullanıcı profilini yükleme işlemini başlatıyoruz
    LaunchedEffect(userId) {
        userViewModel.loadUserProfile(userId)
    }

    // UI Yapısı
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (userProfile != null) {
            UserProfileContent(userProfile!!)
        } else {
            Text(text = "Loading...", fontSize = 20.sp)
        }
    }
}

@Composable
fun UserProfileContent(user: User) {
    Text(text = "Username: ${user.username}", fontSize = 18.sp)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "Email: ${user.email}", fontSize = 18.sp)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "Budget: ${user.budget}", fontSize = 18.sp)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "Preferences: ${user.preferences}", fontSize = 18.sp)
}
