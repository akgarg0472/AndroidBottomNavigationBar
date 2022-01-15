package com.akgarg.bottomnavigationbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.akgarg.bottomnavigationbar.R
import com.google.android.material.snackbar.Snackbar

class LogoutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.logout_fragment, container, false)

        val logoutButton: Button = view.findViewById(R.id.logout_button)
        logoutButton.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setCancelable(false)
            builder.setTitle("Confirm?")
            builder.setMessage("Are you sure want to logout?")
            builder.setPositiveButton("Yes") { _, _ ->
                Snackbar.make(view, "Logout success", Snackbar.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No") {
                dialog, _ -> dialog.dismiss()
            }
            builder.create().show()
        }
        return view
    }


}