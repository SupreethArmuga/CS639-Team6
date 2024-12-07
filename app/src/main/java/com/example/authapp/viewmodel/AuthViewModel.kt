package  com.example.authapp.viewmodel


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authapp.utils.AuthUtils
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    fun signUpWithEmail(email: String, password: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                auth.createUserWithEmailAndPassword(email, password).await()
                onComplete(true)
            } catch (e: Exception) {
                onComplete(false)
            }
        }
    }

    fun getGoogleSignInClient(context: Context) = AuthUtils.getGoogleSignInClient(context)

    fun handleGoogleSignInResult(account: GoogleSignInAccount?, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                if (account == null) {
                    onComplete(false)
                    return@launch
                }

                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                auth.signInWithCredential(credential).await()
                onComplete(true)
            } catch (e: Exception) {
                onComplete(false)
            }
        }
    }
}