package com.example.naverlogin

import android.content.Context
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import com.example.naverlogin.model.GoogleLoginResult
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GoogleSignInHelper(
    private val context: Context,
) {
    companion object {
        const val TAG = "GoogleLogin"
        const val WEB_CLIENT_ID = BuildConfig.GOOGLE_CLIENT_ID
        // const val SERVER_URL = ""
    }

    private val credentialManager: CredentialManager = CredentialManager.create(context)
    private val signInWithGoogleOption: GetSignInWithGoogleOption =
        GetSignInWithGoogleOption
            .Builder(WEB_CLIENT_ID)
            .setNonce("nonce")
            .build()
    private val request: GetCredentialRequest =
        GetCredentialRequest
            .Builder()
            .addCredentialOption(signInWithGoogleOption)
            .build()
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    fun requestGoogleLogin(
        onSuccess: (GoogleLoginResult) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        coroutineScope.launch {
            try {
                val result =
                    credentialManager.getCredential(
                        request = request,
                        context = context,
                    )
                handleSignInResult(result, onSuccess, onFailure)
            } catch (e: GetCredentialException) {
                onFailure("Google Sign-in failed: ${e.localizedMessage}")
            }
        }
    }

    private fun handleSignInResult(
        result: GetCredentialResponse,
        onSuccess: (GoogleLoginResult) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        when (val credential = result.credential) {
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        val googleIdTokenCredential =
                            GoogleIdTokenCredential.createFrom(credential.data)
                        val googleLoginResult =
                            GoogleLoginResult(
                                idToken = googleIdTokenCredential.idToken,
                                id = googleIdTokenCredential.id,
                                displayName = googleIdTokenCredential.displayName,
                            )
                        onSuccess(googleLoginResult)
                    } catch (e: GoogleIdTokenParsingException) {
                        Log.e(TAG, "Received an invalid google id token response", e)
                    }
                } else {
                    Log.e(TAG, "Unexpected type of credential")
                    onFailure("구글 로그인에 실패하였습니다. 다시 시도해주세요.")
                }
            }

            else -> {
                Log.e(TAG, "Unexpected type of credential")
                onFailure("구글 로그인에 실패하였습니다. 다시 시도해주세요.")
            }
        }
    }
    /*private fun sendTokenToServer(token: String, onSuccess: (String) -> Unit, onFailure: (String) -> Unit) {

    }*/
}
