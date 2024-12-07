import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authapp.R
import com.example.authapp.viewmodel.AuthViewModel


@Composable
fun SignupScreen(
    authViewModel: AuthViewModel = viewModel(),
    onSignupSuccess: () -> Unit,
    onGoogleSignInClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AuthTextField(
            value = email,
            onValueChange = { email = it },
            label = stringResource(R.string.email_hint)
        )

        AuthTextField(
            value = password,
            onValueChange = { password = it },
            label = stringResource(R.string.password_hint),
            visualTransformation = PasswordVisualTransformation()
        )

        AuthButton(
            text = stringResource(R.string.sign_up),
            onClick = {
                authViewModel.signUpWithEmail(email, password) { success ->
                    if (success) onSignupSuccess()
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        AuthButton(
            text = stringResource(R.string.sign_in_with_google),
            onClick = onGoogleSignInClick
        )
    }
}