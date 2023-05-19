@file:Suppress("unused", "unused", "unused", "unused", "unused", "RedundantSuppression")

package com.example.bismillahjadi.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.bismillahjadi.MainActivity
import com.example.bismillahjadi.R
import com.example.bismillahjadi.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
@Suppress(
    "RedundantExplicitType", "SameParameterValue", "SameParameterValue"
)
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var sharedpref: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedpref = requireActivity().getSharedPreferences("Register", Context.MODE_PRIVATE)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            login()
        }

        binding.btnReg.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnIndo.setOnClickListener {
            setIndonesia("id")
        }

        binding.btnEng.setOnClickListener {
            setEnglish("eng")
        }

    }

    private fun login(){
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEdiText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(context,"Login Telah Berhasil", Toast.LENGTH_LONG).show()
                    Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_homeFragment)
                }else{
                    Toast.makeText(context, "Email atau Password Kamu Ada Yang Salah",Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    @SuppressLint("AppBundleLocaleChanges")
    private fun setIndonesia(ignoredIndonesia: String) {
        val locale : Locale = Locale("id")
        Locale.setDefault(locale)

        val config: Configuration = Configuration()
        config.locale = locale

        val res = resources
        res.updateConfiguration(config, res.displayMetrics)
        val intent = Intent(activity, MainActivity::class.java)
        requireActivity().startActivity(intent)

    }
    private fun setEnglish(ignoredEnglish: String) {
        val locale : Locale = Locale("eng")
        Locale.setDefault(locale)

        val config: Configuration = Configuration()
        config.locale = locale

        val res = resources
        res.updateConfiguration(config, res.displayMetrics)
        val intent = Intent(activity, MainActivity::class.java)
        requireActivity().startActivity(intent)

    }


}